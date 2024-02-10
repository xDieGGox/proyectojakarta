package ec.edu.ups.ppw63.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Carrito {
	
	@Id
	@GeneratedValue
	private int codigo_carrito;
	
	@ManyToOne(fetch = FetchType.EAGER)//Aqui estaba LAZY
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_carrito")
	private List<Item> items;

	public int getCodigo_carrito() {
		return codigo_carrito;
	}

	public void setCodigo_carrito(int codigo_carrito) {
		this.codigo_carrito = codigo_carrito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		if(items == null)
			items = new ArrayList<Item>();
		
		items.add(item);
	}
	
	
	
}
