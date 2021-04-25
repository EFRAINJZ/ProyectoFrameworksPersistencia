package cursoDAgil.dao.venta;

import java.util.List;


import cursoDAgil.bd.domain.Venta;

public interface VentaDao {
	Integer nuevaVenta(Venta venta);
	List<Venta> obtenerVentas();
	Venta obtenerVentasPorId(Integer idVenta);
	Venta obtenerVentasConProductosPorId(Integer idVenta);
	
}
