package cursoDAgil.dao.direccion;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.direccion.DireccionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DireccionDaoImplTest {
	@Inject
	DireccionDao direccionDao;

	@Ignore
	public void consultarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 1);
		try {
			direccion = direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id:" + direccion.getIdDireccion());
			System.out.println("calle:" + direccion.getCalle());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void borrarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 4);
		try {
			direccion = direccionDao.borrarDireccionPorId(mapDireccion);
			assertNull(direccion);
			System.out.println("Borrada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Ignore
	public void modificarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 2);
		try {
			direccion = direccionDao.modificarDireccionPorId(mapDireccion);
			assertEquals(direccion.getCiudad(), "Mexico");
			System.out.println("Modificada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Ignore
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las direcciones");
		try {
			List<Direccion> lista = direccionDao.obtenerDirecciones();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			System.out.println("error" + ex);

		}
	}

	@Ignore
	public void nuevoRegistro() {
		Direccion direccion = new Direccion();
		System.out.println("Test nuevo registro");
		try {
			direccion.setCalle("Micaela Galindo");
			direccion.setNumero(3);
			direccion.setColonia("Centro");
			direccion.setCiudad("Huajuapan");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(69000);
			direccionDao.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
