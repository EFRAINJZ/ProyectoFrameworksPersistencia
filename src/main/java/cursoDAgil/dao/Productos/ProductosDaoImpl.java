package cursoDAgil.dao.Productos;

import java.util.List;
import java.util.Map;

import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.mappers.ProductosMapper;

@Named
public class ProductosDaoImpl implements ProductosDao{
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		}

	@Override
	public List<Productos> obtenerProductos() {
		List<Productos> list = null;
		try {
			ProductosMapper productosMapper = sqlSession.getMapper(ProductosMapper.class);
			list = productosMapper.obtenerProductos();
			for(Productos p:list) {
				System.out.println("Id: " + p.getIdProducto());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Marca: " + p.getMarcas().getNombreMarca());
			}
			return list;			
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer agregarProductos(Productos productos) {
		try {
			ProductosMapper productosMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("Productos creada con éxito");
			return productosMapper.agregarProductos(productos);
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Productos obtenerProductosPorId(Map<String, Integer> mapProductos) {
		try{
			ProductosMapper productosMapper = sqlSession.getMapper(ProductosMapper.class);
			return productosMapper.obtenerProductosPorId(mapProductos);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarProductoPorId(Map<String, Integer> mapProductos) {
		try{
			ProductosMapper productosMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("Producto eliminado con éxito");
			return productosMapper.eliminarProductoPorId(mapProductos);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer modificarProducto(Productos productos) {
		try {
			ProductosMapper productosMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("Productos modificados con éxito");
			return productosMapper.modificarProducto(productos);
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

}
