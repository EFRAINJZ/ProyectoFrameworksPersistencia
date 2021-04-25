package cursoDAgil.dao.Marca;

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

import cursoDAgil.bd.domain.Marca;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class MarcaDaoImplTest {
	@Inject
	MarcaDao marcaDao;
	@Ignore
	public void pruebaNuevoRegistro() {
		Marca marca=new Marca();
		System.out.println("Test nuevo registro");
		try{
			marca.setNombreMarca("Nike");
			marcaDao.nuevaMarca(marca);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Ignore
	public void pruebActualizarMarca(){
		Marca marca=new Marca();
		System.out.println("Test actualizar registro");
		try{
			marca.setIdMarca(2);
			marca.setNombreMarca("Adidas");
			marcaDao.actualizarMarca(marca);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las marcas");
		try{
			List<Marca> lista=marcaDao.obtenerMarcas();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\n Registros en la tabla "+reg);
			
		}catch(Exception e){
			System.out.println("error" + e);
		}
	}

	@Ignore
	public void pruebaObtenerMarcaPorId(){
		Marca marca=new Marca();
		Map<String, Integer> mapMarca=new HashMap<>();
		mapMarca.put("idMarca",1);
		
	   try{
		  marca=marcaDao.obtenerMarcaPorId(mapMarca);
		  assertNotNull(marca);
		  System.out.println("id: " + marca.getIdMarca());
		  System.out.println("Nombre: " + marca.getNombreMarca());
	   }catch(Exception e){
	      System.out.println("Error: " + e);
	   }
	}
	@Ignore
	public void pruebaBorrarMarca(){
		
		Map<String, Integer> mapMarca=new HashMap<>();
		mapMarca.put("idMarca",2);
		System.out.println("Test borrar marca");

		try{
			  marcaDao.borrarMarca(mapMarca);
			  
		   }catch(Exception e){
		      System.out.println("Error: " + e);
		   }
	}
}
