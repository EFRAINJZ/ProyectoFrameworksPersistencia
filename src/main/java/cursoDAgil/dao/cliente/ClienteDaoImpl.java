package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.mappers.ClienteMapper;


@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2996238527625357987L;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> list = null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			for(Cliente c:list){
				System.out.println("Id: "+ c.getId());
				System.out.println("Nombre: "+ c.getNombre());
				System.out.println("Apellido: "+c.getApellido());
				System.out.println("Email: "+c.getEmail());
				System.out.println("Direccion: "+c.getDireccion().getCalle());
			}
			return list;
		} catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}
	
	
	public Integer agregarCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente creado con éxito");
			return clienteMapper.agregarCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return null;
	}
	
	public Cliente obtenerClientePorId(Map<String,Integer>mapCliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);

			return clienteMapper.obtenerClientePorId(mapCliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return null;
	}
	
	public Integer actualizaCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);

			return clienteMapper.actualizaCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		
		return null;
	}
	
	public Integer eliminarCliente(Map<String,Integer>mapCliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);

			return clienteMapper.eliminarCliente(mapCliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return null;	
	}
	
}
