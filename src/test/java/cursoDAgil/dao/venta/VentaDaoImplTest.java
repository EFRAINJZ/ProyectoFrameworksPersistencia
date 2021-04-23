package cursoDAgil.dao.venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;


import javax.inject.Inject;

import org.junit.Ignore;

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
	@Ignore
	public void pruebaObtenerVentaPorId(){
	
		Venta venta=new Venta();
		int idVenta=4;
		System.out.println("Test obtener ventaa por id");
		try{
			 venta=ventasDao.obtenerVentasPorId(idVenta);
			assertNotNull(venta);
			System.out.println("Id Venta:"+venta.getIdVenta());
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	@Ignore
	public void pruebaObtenerVentaConProductosPorId(){
		
		Venta venta=new Venta();
		int idVenta=4;
		
		System.out.println("Test obtener ventaa por id");
		try{
			 venta=ventasDao.obtenerVentasConProductosPorId(idVenta);
			assertNotNull(venta);
			
			System.out.println("Id Venta:"+venta.getIdVenta());
			
			
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}

}
