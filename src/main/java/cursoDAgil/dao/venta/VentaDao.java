package cursoDAgil.dao.venta;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Venta;

public interface VentaDao {
	List<Venta> obtenerVentas();
	List<Venta> obtenerVentasPorCliente(Map<String, Integer> mapVenta);
	Integer nuevaVenta(Venta venta);
	
}
