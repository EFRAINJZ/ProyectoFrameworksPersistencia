package cursoDAgil.dao.venta;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cursoDAgil.bd.domain.DetallesVenta;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.VentaMapper;
import cursoDAgil.dao.Productos.ProductosDao;
import cursoDAgil.dao.detallesVenta.DetallesVentaDao;
import cursoDAgil.dao.detallesVenta.DetallesVentaDaoImpl;
import cursoDAgil.dao.ganancias.GananciasDao;
@Named
public class VentaDaoImpl implements VentaDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8867420650257040298L;
	SqlSession sqlSession;
	
	@Inject
	DetallesVentaDao detalleVentaDao;
	
	@Inject
	ProductosDao productosDao;
	
	@Inject
	GananciasDao gananciasDao;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Venta> obtenerVentas() {
		List<Venta> list=null;
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			list= ventaMapper.obtenerVentas();
			for(Venta vtas:list){
				System.out.println("IdVenta: "+vtas.getIdVenta());
				System.out.println("Cliente: "+vtas.getCliente().getNombre());
				
			}
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Venta obtenerVentasPorId( Integer idVenta) {
		Venta venta=null;
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			venta= ventaMapper.obtenerVentasPorId(idVenta);
			System.out.println("IdVenta: "+venta.getIdVenta());
			System.out.println("Cliente: "+venta.getCliente().getNombre());
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public Venta obtenerVentasConProductosPorId( Integer idVenta) {
		Venta venta=null;
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			venta= ventaMapper.obtenerVentasPorId(idVenta);
			System.out.println("IdVenta: "+venta.getIdVenta());
			System.out.println("Cliente: "+venta.getCliente().getNombre());
			List<Productos> productos=venta.getProductos();
			for(Productos prod:productos){
			   System.out.println("Nombre producto: "+prod.getNombre());
			   System.out.println("Cantidad: "+prod.getCantidad());
			}
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Transactional
	@Override
	public Integer nuevaVenta(Venta venta) {
		try{
			int bandera=1;
			System.out.println("Nope");
			Double ganancia=0.0;
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			System.out.println("Nope");
			ventaMapper.nuevaVenta(venta);
			System.out.println("ide venta: "+venta.getIdVenta());
			Integer idVenta = venta.getIdVenta();
			
			List<Productos> productos = venta.getProductos();
			Ganancias nganancia= new Ganancias();
			nganancia.setVentaId(idVenta);
			for(Productos prod: productos){
				System.out.println("No pos si llega");
				DetallesVenta detalleVenta = new DetallesVenta();
				detalleVenta.setVentaId(idVenta);
				detalleVenta.setProductoId(prod.getIdProducto());
				detalleVenta.setCantidad(prod.getCantidad());
				Productos productoExistente = new Productos();
				Map<String, Integer> mapProducto = new HashMap<>();
				mapProducto.put("idProducto", prod.getIdProducto());
				productoExistente=productosDao.obtenerProductosPorId(mapProducto);
				productoExistente.setCantidad(productoExistente.getCantidad()-prod.getCantidad());
				ganancia+=prod.getCantidad()*(prod.getPrecioVta()-prod.getPrecio());
				if (productoExistente.getCantidad()>=0){
					detalleVentaDao.nuevoDetallesVenta(detalleVenta);
					productosDao.modificarProducto(productoExistente);
				}else{
					System.out.println("No pos no hay 	");
				}
			}
			System.out.println("Venta agregada con éxito");
			return ventaMapper.nuevaVenta(venta);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	


}
