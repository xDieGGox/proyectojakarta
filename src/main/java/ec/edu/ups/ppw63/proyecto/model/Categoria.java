package ec.edu.ups.ppw63.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private int codigo_categoria;
	private String nombre;
	
	
	public int getCodigo_categoria() {
		return codigo_categoria;
	}
	public void setCodigo_categoria(int codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Categoria [codigo_categoria=" + codigo_categoria + ", nombre=" + nombre + "]";
	}
	
	
	
}
