package cursoDAgil.dao.venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.dao.Productos.ProductosDao;
import cursoDAgil.dao.cliente.ClienteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class VentaDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	@Inject
	VentaDao ventasDao;
	@Inject
	ProductosDao productoDao;
	
	
	@Test
	public void pruebaObtenerVentas(){
		int reg;
		System.out.println("Test obtener todas las ventas");

		
		try{
			List<Venta> lista=ventasDao.obtenerVentas();
			
			reg = lista.size();
			System.out.println("\nRegistros en la tabla ventas: " + reg);
			assertEquals(lista.size(), reg);
			for(Venta vtas:lista){
				System.out.println("IdVenta: "+vtas.getIdVenta());
				System.out.println("Cliente: "+vtas.getCliente().getNombre());
				System.out.println("IdVenta: "+vtas.getFecha());
				System.out.println("IdVenta: "+vtas.getTotalVenta());
				System.out.println();


				
			}
			
		}catch(Exception e){
			System.out.println("Error en test "+e);
		}
	}
	@Ignore
	public void pruebaObtenerVentaPorId(){
	
		Venta venta=new Venta();
		int idVenta=9;
		System.out.println("Test obtener ventaa por id");
		try{
			 venta=ventasDao.obtenerVentasPorId(idVenta);
			assertNotNull(venta);
			
			System.out.println("IdVenta: "+venta.getIdVenta());
			System.out.println("Cliente: "+venta.getCliente().getNombre()
					+" "+venta.getCliente().getApellido());
			Direccion direccion=venta.getCliente().getDireccion();
			System.out.println("Calle : "+direccion.getCalle());
			System.out.println("Colonia : "+direccion.getColonia());
			System.out.println("Ciudad : "+direccion.getCiudad());
			System.out.println("Estado : "+direccion.getEstado());
			System.out.println("Pais : "+direccion.getPais());
			System.out.println("Codigo postal : "+direccion.getCodigoPostal());
			System.out.println("Numero : "+direccion.getNumero());
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	@Test
	public void pruebaObtenerVentaConProductosPorId(){
		
		Venta venta=new Venta();
		int idVenta=1;
		
		System.out.println("Test obtener ventas con productos por id");
		try{
			venta=ventasDao.obtenerVentasConProductosPorId(idVenta);
			assertNotNull(venta);
			System.out.println("IdVenta: "+venta.getIdVenta());
			System.out.println("Cliente: "+venta.getCliente().getNombre()
					+" "+venta.getCliente().getApellido());
			Direccion direccion=venta.getCliente().getDireccion();
			System.out.println("Calle : "+direccion.getCalle());
			System.out.println("Colonia : "+direccion.getColonia());
			System.out.println("Ciudad : "+direccion.getCiudad());
			System.out.println("Estado : "+direccion.getEstado());
			System.out.println("Pais : "+direccion.getPais());
			System.out.println("Codigo postal : "+direccion.getCodigoPostal());
			System.out.println("Numero : "+direccion.getNumero());
			
			 System.out.println();
			List<Productos> productos=venta.getProductos();
			if(productos==null){
				System.out.println("No se encontraron productos");

			}else
			for(Productos prod:productos){
			   System.out.println("Nombre producto: "+prod.getNombre());
			   System.out.println("Marca del producto: "+prod.getMarcas().getNombreMarca());
			   System.out.println("Precio de venta: "+prod.getPrecioVta());
			   System.out.println("Cantidad: "+prod.getCantidad());
			   System.out.println();
			}
			System.out.println("Id Venta:"+venta.getIdVenta());
			
			
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	
	
	
	
	@Ignore
	public void pruebaNuevaVenta(){
		Venta nuevaVenta = new Venta();
		List<Productos> carrito = new ArrayList<Productos>();
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		Double totalVenta=0.0;
		System.out.println("Prueba nueva venta");
		try {
			
			mapCliente.put("id", 3);
			cliente = clienteDao.obtenerClientePorId(mapCliente);	
			
			nuevaVenta.setCliente(cliente);
			nuevaVenta.setClienteId(cliente.getId());
			
			Map<String, Integer> mapProducto = new HashMap<>();
			
			for(int i=4; i<=5; i++){
				mapProducto.put("idProducto", i);
				
				Productos producto = new Productos();
				producto=productoDao.obtenerProductosPorId(mapProducto);
				assertNotNull(producto);
				producto.setCantidad(2);
				totalVenta+=producto.getCantidad()*producto.getPrecioVta();
				carrito.add(producto);
			}
			nuevaVenta.setTotalVenta(totalVenta);
			nuevaVenta.setProductos(carrito);
			nuevaVenta.setFecha("2021-04-21");
			ventasDao.nuevaVenta(nuevaVenta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		System.out.println("Terminado");
		
	}

}
