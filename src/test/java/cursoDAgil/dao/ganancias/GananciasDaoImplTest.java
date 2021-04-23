package cursoDAgil.dao.ganancias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cursoDAgil.bd.domain.Ganancias;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class GananciasDaoImplTest {
	@Inject
	GananciasDao gananciasDao;

	@Ignore
	public void obtenerGananciasPorFecha() {
		//Ganancias ganancias = new Ganancias();
		Map<String, String> mapGanancias = new HashMap<>();
		mapGanancias.put("fecha", "2021-04-01");
		try {
			List<Ganancias> ganancias = gananciasDao.obtenerGananciasPorFecha(mapGanancias);
			assertNotNull(ganancias);
			//System.out.println("fecha:" + ganancias.getFecha());
			//System.out.println("ganacia:" + ganancias.getTotalGanancia());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las ganancias");
		try {
			List<Ganancias> lista = gananciasDao.obtenerGanancias();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			// System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}

	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		System.out.println("Test nuevo registro");
		try {
			ganancia.setVentaId(3);
			ganancia.setTotalGanancia(2123.90);
			ganancia.setFecha("2021-04-14");
			gananciasDao.nuevaGanancia(ganancia);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
