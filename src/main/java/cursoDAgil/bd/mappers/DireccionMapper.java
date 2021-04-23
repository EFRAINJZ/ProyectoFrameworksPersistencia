package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionMapper {
	List<Direccion> obtenerDirecciones();
	Integer nuevaDireccionCliente(Direccion direccion);
	Direccion obtenerDireccionPorId(Map<String, Integer>mapDireccion);
	Direccion borrarDireccionPorId(Map<String, Integer> mapDireccion);
	Integer modificarDireccionPorId(Direccion direccion);
}
