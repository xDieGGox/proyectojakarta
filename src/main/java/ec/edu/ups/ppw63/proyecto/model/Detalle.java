package ec.edu.ups.ppw63.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalle {
	
	@Id
	@GeneratedValue
	private int codigo_detalle;
	
	private String descripcion_detalle;
	private Double precioUnitario_detalle; 
	private int cantidad_detalle;
	private Double precioTotal_detalle;
	
	@ManyToOne
	@JoinColumn(name="factura_codigo_factura")
	private Factura factura;

	public int getCodigo_detalle() {
		return codigo_detalle;
	}

	public void setCodigo_detalle(int codigo_detalle) {
		this.codigo_detalle = codigo_detalle;
	}

	public String getDescripcion_detalle() {
		return descripcion_detalle;
	}

	public void setDescripcion_detalle(String descripcion_detalle) {
		this.descripcion_detalle = descripcion_detalle;
	}

	public Double getPrecioUnitario_detalle() {
		return precioUnitario_detalle;
	}

	public void setPrecioUnitario_detalle(Double precioUnitario_detalle) {
		this.precioUnitario_detalle = precioUnitario_detalle;
	}

	public int getCantidad_detalle() {
		return cantidad_detalle;
	}

	public void setCantidad_detalle(int cantidad_detalle) {
		this.cantidad_detalle = cantidad_detalle;
	}

	public Double getPrecioTotal_detalle() {
		return precioTotal_detalle;
	}

	public void setPrecioTotal_detalle(Double precioTotal_detalle) {
		this.precioTotal_detalle = precioTotal_detalle;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
	
	
}
