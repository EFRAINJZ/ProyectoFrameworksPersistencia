package cursoDAgil.dao.Productos;

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

import cursoDAgil.bd.domain.Productos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class ProductosDaoImplTest {
	
	@Inject
	ProductosDao productosDao;
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todos los productos");
		try {
			List<Productos> lista = productosDao.obtenerProductos();
			reg = lista.size();
			assertEquals(lista.size(),reg);
		} catch(Exception ex) {
			System.out.println("error" + ex);
		}
	}
	
	@Test
	public void nuevoRegistro() {
		Productos productos = new Productos();
		System.out.println("Test nuevo registro");
		
		try {
			productos.setNombre("Taza");
			productos.setPrecio(22);
			productos.setPrecioVta(33);
			productos.setCantidad(274);
			productos.setMarcaId(2);
			productosDao.agregarProductos(productos);
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void consultarProductosPorId(){
		Productos productos = new Productos();
		System.out.println("Test Buscar Producto por Id");
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idProducto",2);
		try{
			productos = productosDao.obtenerProductosPorId(mapDireccion);
			assertNotNull(productos);
			System.out.println("id:" + productos.getIdProducto());
			System.out.println("Nombre:" + productos.getNombre());
			System.out.println("Nombre marca:" + productos.getMarcas().getNombreMarca());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void eliminarProducto() {
		Productos productos = new Productos();
		System.out.println("Test eliminar un producto por id");
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idProducto",6);
		
		try{
			productosDao.eliminarProductoPorId(mapDireccion);
			assertNotNull(productos);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}
	
	@Test
	public void modificarProducto() {
		Productos productos = new Productos();
		System.out.println("Test modificar productos");
		try {
			productos.setIdProducto(2);
			productos.setNombre("Procesador");
			productos.setPrecio(4000);
			productos.setPrecioVta(5678);
			productos.setCantidad(123);
			productosDao.modificarProducto(productos);
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	

}
