package cursoDAgil.dao.venta;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.VentaMapper;
@Named
public class VentaDaoImpl implements VentaDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8867420650257040298L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Venta> obtenerVentas() {
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			return ventaMapper.obtenerVentas();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Venta> obtenerVentasPorCliente(Map<String, Integer> mapVenta) {
		try{
			VentaMapper ventaMapper=sqlSession.getMapper(VentaMapper.class);
			return ventaMapper.obtenerVentasPorCliente(mapVenta);
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
