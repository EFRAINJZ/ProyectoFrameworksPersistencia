package cursoDAgil.bd.domain;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private	int idVenta;
	private int clienteId;
	private double totalVenta;
	private	String fecha;
	private Cliente cliente;
	private List<Productos> productos;
	public void Ventas(){
	     setCliente(new Cliente());
	     setProductos(new ArrayList<Productos>());
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Productos> getProductos() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
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
