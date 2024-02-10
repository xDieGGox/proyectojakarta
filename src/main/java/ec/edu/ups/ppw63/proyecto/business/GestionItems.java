package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.ItemDAO;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionItems {
	
	@Inject
	private ItemDAO daoItem;
	
	public void guardarItems(Item item) {
		
		Item ite = daoItem.read(item.getCodigo_item());
		if(ite!= null) {
			daoItem.update(item);	
		}else { 
			daoItem.insert(item); 
		}
		
	}
	
	public void actualizarItem(Item item) throws Exception {
		Item ite = daoItem.read(item.getCodigo_item());
		if (ite != null){
			daoItem.update(item);
		}else {
			throw new Exception("Item no existe");
		}
	}
	
	
	public void borrarItem(int codigo) {
		
		daoItem.remove(codigo); 
	}
	
	public List<Item> getItems(){
		return daoItem.getAll();
	}
	
	
	public List<Item> getItemsporCodigoCarrito(int codigoCarrito){
		return daoItem.getItemsByCarrito(codigoCarrito);
	}
	
}
