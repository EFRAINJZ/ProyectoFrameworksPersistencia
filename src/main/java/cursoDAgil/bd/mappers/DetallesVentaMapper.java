package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetallesVenta;

public interface DetallesVentaMapper {
	Integer nuevoDetallesVenta(DetallesVenta detallesVenta);
	List<DetallesVenta> obtenerDetallesVenta(Map<String, Integer> mapDetallesVenta);
	
}
