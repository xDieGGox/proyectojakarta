package ec.edu.ups.ppw63.proyecto.model;

public class CantidadCarritosCliente {
	private int codigo_cliente;
	private String nombre_cliente;
	private int cantidad_carritos;
	
	
	public CantidadCarritosCliente(int codigo_cliente, String nombre_cliente, int cantidad_carritos) {
		super();
		this.codigo_cliente = codigo_cliente;
		this.nombre_cliente = nombre_cliente;
		this.cantidad_carritos = cantidad_carritos;
	}


	public int getCodigo_cliente() {
		return codigo_cliente;
	}


	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}


	public String getNombre_cliente() {
		return nombre_cliente;
	}


	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}


	public int getCantidad_carritos() {
		return cantidad_carritos;
	}


	public void setCantidad_carritos(int cantidad_carritos) {
		this.cantidad_carritos = cantidad_carritos;
	}


	@Override
	public String toString() {
		return "CantidadCarritosCliente [codigo_cliente=" + codigo_cliente + ", nombre_cliente=" + nombre_cliente
				+ ", cantidad_carritos=" + cantidad_carritos + "]";
	}
	
	
	
	
}
