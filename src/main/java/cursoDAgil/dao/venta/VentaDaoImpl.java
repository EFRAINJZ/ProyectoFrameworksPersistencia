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
			return list;
			
		}catch (Exception e) {
			System.out.println("Error en ventas: " + e);
		}
		return null;
	}
	
	@Override
	public Venta obtenerVentasPorId( Integer idVenta) {
		Venta venta=null;
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			venta= ventaMapper.obtenerVentasPorId(idVenta);
			
			return venta;
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
			venta= ventaMapper.obtenerVentasConProductosPorId(idVenta);
			
			return venta;
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
			
			Double ganancia=0.0;
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			
			ventaMapper.nuevaVenta(venta);
			System.out.println("id venta: "+venta.getIdVenta());
			Integer idVenta = venta.getIdVenta();
			
			List<Productos> productos = venta.getProductos();
			Ganancias nganancia= new Ganancias();
			nganancia.setVentaId(idVenta);
			for(Productos prod: productos){
				DetallesVenta detalleVenta = new DetallesVenta();
				
				detalleVenta.setVentaId(idVenta);
				detalleVenta.setProductoId(prod.getIdProducto());
				//Consulta para obtener los datos del prodcuto en la bd
				Productos productoExistente = new Productos();
				Map<String, Integer> mapProducto = new HashMap<>();
				mapProducto.put("idProducto", prod.getIdProducto());
				productoExistente=productosDao.obtenerProductosPorId(mapProducto);
				
				if (productoExistente!=null && productoExistente.getCantidad()>0){
					
					detalleVenta.setCantidad(prod.getCantidad());
					
					if(prod.getCantidad()<=productoExistente.getCantidad()){
						productoExistente.setCantidad(productoExistente.getCantidad()-prod.getCantidad());
						ganancia+=prod.getCantidad()*(prod.getPrecioVta()-prod.getPrecio());
					}
					else{
						ganancia+=productoExistente.getCantidad()*(prod.getPrecioVta()-prod.getPrecio());
						productoExistente.setCantidad(0);
					}
					  
					
					detalleVentaDao.nuevoDetallesVenta(detalleVenta);
					productosDao.modificarProducto(productoExistente);
				}
			}
			System.out.println("Venta agregada con éxito");
			//return ventaMapper.nuevaVenta(venta);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	


}
