package cursoDAgil.dao.direccion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class DireccionDaoImpl implements DireccionDao, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3514598916206774039L;
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Direccion> obtenerDirecciones() {
		List<Direccion> list = null;
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			list = direccionMapper.obtenerDirecciones();
			for(Direccion c:list){
				System.out.println("IdDireccion: "+ c.getIdDireccion());
				System.out.println("Calle: "+ c.getCalle());
				System.out.println("Ciudad: "+c.getCiudad());
				System.out.println("Colonia: "+c.getColonia());
				System.out.println("Estado: "+c.getEstado());
				System.out.println("Pais: "+c.getPais());
			}
			return list;
		} catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);

			System.out.println("direccion creada con éxito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {

		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);

			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Direccion borrarDireccionPorId(Map<String, Integer> mapDireccion){
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);

			return direccionMapper.borrarDireccionPorId(mapDireccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
		
	}

	
	
	@Override
	public Integer modificarDireccionPorId(Direccion direccion){
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.modificarDireccionPorId(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
		
		
	}
	

}
