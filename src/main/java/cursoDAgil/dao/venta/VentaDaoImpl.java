package cursoDAgil.dao.venta;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.VentaMapper;
import cursoDAgil.dao.Productos.ProductosDao;
import cursoDAgil.dao.detallesVenta.DetallesVentaDao;
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

	@Override
	public Integer nuevaVenta(Venta venta) {
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			System.out.println("Venta agregada con éxito");
			return ventaMapper.nuevaVenta(venta);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	

}
