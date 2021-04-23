package cursoDAgil.bd.domain;

public class Venta {
	private	int idVenta;
	private int clienteId;
	private double totalVenta;
	private	String fecha;
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 	
	
}
