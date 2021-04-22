package cursoDAgil.bd.domain;

public class DetallesVenta {
	private int VentaId;
	private int productoId;
	private int cantidad;
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
