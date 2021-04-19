package cursoDAgil.dao.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;


public interface ClienteDao {
List<Cliente> listarTodosClientes();
Integer agregarCliente(Cliente cliente);
Cliente obtenerClientePorId(Map<String,Integer>mapCliente);
Integer actualizaCliente(Cliente cliente);
Integer eliminarCliente(Map<String,Integer>mapCliente);
 

}
