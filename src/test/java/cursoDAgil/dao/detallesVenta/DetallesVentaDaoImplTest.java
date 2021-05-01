package cursoDAgil.dao.detallesVenta;

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

import cursoDAgil.bd.domain.DetallesVenta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class DetallesVentaDaoImplTest {
	@Inject
	DetallesVentaDao detallesVentaDao;
	
	@Ignore
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test para consultar los detalles ventas");
		try {
			List<DetallesVenta> lista= detallesVentaDao.ListarTodosLosDetalles();
			reg = lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("error: "+ex);
		}
	}
	@Ignore
	public void pruebaNuevoDetallesVenta(){
		DetallesVenta detallesVenta=new DetallesVenta();
		System.out.println("Test nuevo detalles venta");
		try{
			detallesVenta.setCantidad(4);
			detallesVenta.setProductoId(2);
			detallesVenta.setVentaId(1);
			detallesVentaDao.nuevoDetallesVenta(detallesVenta);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	@Test
	public void pruebaObtenerDetallesVenta(){
		int reg;
		int idVenta=9;
		Map<String, Integer> mapDetallesVenta = new HashMap<>();
		mapDetallesVenta.put("ventaId",idVenta);
		System.out.println("Test obtener detalles venta");
		
		try{
			List<DetallesVenta> lista=detallesVentaDao.obtenerDetallesVenta(mapDetallesVenta);
			reg = lista.size();
			
			assertEquals(lista.size(), reg);
			System.out.println("Detalles de la venta con id: "+idVenta);
			System.out.println("\nRegistros en la tabla detalles ventas: " + reg);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	
	
}
