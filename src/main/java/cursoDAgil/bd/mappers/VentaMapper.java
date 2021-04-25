package cursoDAgil.bd.mappers;

import java.util.List;


import cursoDAgil.bd.domain.Venta;

public interface VentaMapper {
	Integer nuevaVenta(Venta venta);
	
	List<Venta> obtenerVentas();
	Venta obtenerVentasPorId(Integer idVenta);
	Venta obtenerVentasConProductosPorId(Integer idVenta);
	
	
}
