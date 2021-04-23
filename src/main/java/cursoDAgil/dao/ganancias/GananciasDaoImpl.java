package cursoDAgil.dao.ganancias;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.mappers.GananciasMapper;

@Named
public class GananciasDaoImpl implements GananciasDao {
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);

			System.out.println("Ganancia agregada con éxito");
			return gananciasMapper.nuevaGanancia(ganancias);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Ganancias> obtenerGananciasPorFecha(Map<String, String> mapGanancias) {
		List<Ganancias> list_gan = null;
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			list_gan = gananciasMapper.obtenerGananciasPorFecha(mapGanancias);
			for (Ganancias g : list_gan){
				System.out.println("Fecha" + g.getFecha());
				System.out.println("Id:" + g.getIdGanancia());
				System.out.println("Id de la venta:" + g.getVentaId());
				System.out.println("Ganancia:" + g.getTotalGanancia());
			}
			return list_gan;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Ganancias> obtenerGanancias() {
		List<Ganancias> list = null;
		try {
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			list = gananciasMapper.obtenerGanancias();
			for (Ganancias g : list) {
				System.out.println("Id: " + g.getIdGanancia());
				System.out.println("ventaID: " + g.getVentaId());
				System.out.println("totalGanancia: " + g.getTotalGanancia());
				System.out.println("fecha: " + g.getFecha());
			}
			return list;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

}
