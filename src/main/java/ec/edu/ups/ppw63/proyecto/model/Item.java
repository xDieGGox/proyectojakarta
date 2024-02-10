package ec.edu.ups.ppw63.proyecto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private int codigo_item;
	
	private int cantidad_item;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="carrito_codigo_carrito")
	private Carrito carrito;

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public int getCodigo_item() {
		return codigo_item;
	}

	public void setCodigo_item(int codigo_item) {
		this.codigo_item = codigo_item;
	}

	public int getCantidad_item() {
		return cantidad_item;
	}

	public void setCantidad_item(int cantidad_item) {
		this.cantidad_item = cantidad_item;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
	
	
	
	
}
