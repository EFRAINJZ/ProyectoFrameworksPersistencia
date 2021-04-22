package cursoDAgil.dao.detallesVenta;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetallesVenta;

public interface DetallesVentaDao {
	Integer nuevoDetallesVenta(DetallesVenta detallesVenta);
	List<DetallesVenta> obtenerDetallesVenta(Map<String, Integer> mapDetallesVenta);
	List<DetallesVenta> ListarTodosLosDetalles();
}
