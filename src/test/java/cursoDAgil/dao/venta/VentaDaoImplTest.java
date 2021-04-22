package cursoDAgil.dao.venta;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Venta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class VentaDaoImplTest {
	@Inject
	VentaDao ventasDao;
	@Ignore
	public void pruebaNuevaVenta(){
		Venta venta=new Venta();
		System.out.println("Test nueva venta");
		try{
			venta.setClienteId(4);
			venta.setTotalVenta(80.50);
			venta.setFecha("2011-04-02");
			ventasDao.nuevaVenta(venta);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	@Ignore
	public void pruebaObtenerVentas(){
		int reg;
		System.out.println("Test obtener todas las ventas");
		try{
			List<Venta> lista=ventasDao.obtenerVentas();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla ventas: " + reg);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	@Test
	public void pruebaObtenerVentasPorCliente(){
		int reg;
		int idCliente=4;
		Map<String, Integer> mapVentas = new HashMap<>();
		mapVentas.put("idCliente",idCliente);
		System.out.println("Test obtener ventas por cliente");
		try{
			List<Venta> lista=ventasDao.obtenerVentasPorCliente(mapVentas);
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("Ventas del cliente con id: "+idCliente);
			System.out.println("\nRegistros en la tabla ventas: " + reg);
			
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}

}
