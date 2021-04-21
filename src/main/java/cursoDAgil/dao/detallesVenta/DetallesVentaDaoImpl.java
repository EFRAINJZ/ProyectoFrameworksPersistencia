package cursoDAgil.dao.detallesVenta;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.DetallesVenta;
import cursoDAgil.bd.mappers.DetallesVentaMapper;
@Named
public class DetallesVentaDaoImpl implements DetallesVentaDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5024877399067049107L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public Integer nuevoDetallesVenta(DetallesVenta detallesVenta) {
		try{
			DetallesVentaMapper detallesVentaMapper=sqlSession.getMapper(DetallesVentaMapper.class);
			System.out.println("Detalles de Venta agregados con éxito");
			return detallesVentaMapper.nuevoDetallesVenta(detallesVenta);
		}catch(Exception e){
			System.out.println("Error "+e);
		}

		return null;
	}

	@Override
	public List<DetallesVenta> obtenerDetallesVenta(Map<String, Integer> mapDetallesVenta) {
		try{
			DetallesVentaMapper detallesVentaMapper=sqlSession.getMapper(DetallesVentaMapper.class);
			return detallesVentaMapper.obtenerDetallesVenta(mapDetallesVenta);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
		return null;
	}

}
