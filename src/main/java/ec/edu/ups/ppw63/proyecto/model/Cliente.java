package ec.edu.ups.ppw63.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int codigo_cliente;
	private String cedula_cliente;
	private String nombre_cliente;
	private String correo_cliente;
	private String clave_cliente;
	private String direccion_cliente;
	
	
	
	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	public String getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public String getCorreo_cliente() {
		return correo_cliente;
	}
	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}
	public String getClave_cliente() {
		return clave_cliente;
	}
	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}
	
	
	
	
	
	
	
	
	
	
	
}
