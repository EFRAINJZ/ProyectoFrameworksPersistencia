package cursoDAgil.dao.Marca;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Marca;
import cursoDAgil.bd.mappers.MarcaMapper;
@Named
public class MarcaDaoImpl implements MarcaDao,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6770129180415809456L;
	/**
	 * 
	 */
	
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Marca> obtenerMarcas() {
		try {
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);

			return marcaMapper.obtenerMarcas();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaMarca(Marca marca) {
		try {
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);

			System.out.println("marca creada con éxito");
			return marcaMapper.nuevaMarca(marca);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Marca obtenerMarcaPorId(Map<String, Integer> mapMarca) {
		// TODO Auto-generated method stub
		try{ 
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			return marcaMapper.obtenerMarcaPorId(mapMarca);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer actualizarMarca(Marca marca) {
		try{
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			System.out.println("marca actualizada con éxito");
			return marcaMapper.actualizaMarca(marca);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer borrarMarca(Map<String, Integer> mapMarca) {
		try{ 
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			System.out.println("marca borrada con exito");
			return marcaMapper.borrarMarca(mapMarca);
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	

	
	
}
