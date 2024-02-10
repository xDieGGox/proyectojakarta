package ec.edu.ups.ppw63.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	@GeneratedValue
	private int codigo_factura;
	
	private String numero_factura;
	
	private Double subtotal_factura;
	
	private Double total_factura;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_factura")
	private List<Detalle> detalles;

	public int getCodigo_factura() {
		return codigo_factura;
	}

	public void setCodigo_factura(int codigo_factura) {
		this.codigo_factura = codigo_factura;
	}

	public String getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(String numero_factura) {
		this.numero_factura = numero_factura;
	}

	public Double getSubtotal_factura() {
		return subtotal_factura;
	}

	public void setSubtotal_factura(Double subtotal_factura) {
		this.subtotal_factura = subtotal_factura;
	}

	public Double getTotal_factura() {
		return total_factura;
	}

	public void setTotal_factura(Double total_factura) {
		this.total_factura = total_factura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public void addDetalle(Detalle detalle) {
		if(detalles == null)
			detalles = new ArrayList<Detalle>();
		
		detalles.add(detalle);
	}
	
	
	
}
