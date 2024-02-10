package ec.edu.ups.ppw63.proyecto.model;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	private int codigo_producto;
	@Column(length = 100000)
	private String imagen_producto;
	private String nombre_producto;
	private Double precio_producto;
	
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private Categoria categoria;

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	
	public String getImagen_producto() {
		return imagen_producto;
	}

	public void setImagen_producto(String imagen_producto) {
		this.imagen_producto = imagen_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(Double precio_producto) {
		this.precio_producto = precio_producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto
				+ ", precio_producto=" + precio_producto + ", categoria=" + categoria + "]";
	}
	
	
}
