package cursoDAgil.bd.domain;

public class DetallesVenta {
	private int VentaId;
	private int productoId;
	private int cantidad;
	private Productos productos;
	public DetallesVenta(){
		setProducto(new Productos());
	}
	
	public Productos getProducto() {
		return productos;
	}

	public void setProducto(Productos producto) {
		this.productos = producto;
	}



	public int getVentaId() {
		return VentaId;
	}
	public void setVentaId(int ventaId) {
		VentaId = ventaId;
	}
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
