package cursoDAgil.bd.mappers;

import java.util.List;
//import java.util.Map;
import java.util.Map;

import cursoDAgil.bd.domain.Marca;

public interface MarcaMapper {
	List<Marca> obtenerMarcas();
	Integer nuevaMarca(Marca marca);
	Marca obtenerMarcaPorId(Map<String,Integer> mapMarca);
	Integer actualizaMarca(Marca marca);
	Integer borrarMarca(Map<String,Integer> mapMarca);
}
