package cursoDAgil.bd.domain;

public class Productos {
	private Integer idProducto;
	private String nombre;
	private Integer precio;
	private Integer precioVta;
	private Integer cantidad;
	private Integer marcaId;
	private Marca marcas;
	
	public Productos() {
		setMarcas(new Marca());
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public Integer getPrecioVta() {
		return precioVta;
	}
	
	public void setPrecioVta(Integer precioVta) {
		this.precioVta = precioVta;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getMarcaId() {
		return marcaId;
	}
	
	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public Marca getMarcas() {
		return marcas;
	}

	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}
	
}
