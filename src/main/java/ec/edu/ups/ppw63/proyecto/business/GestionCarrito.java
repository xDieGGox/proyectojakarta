package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.CarritoDAO;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarrito {
	
	@Inject
	private CarritoDAO daoCarrito;
	
	
	public void guardarCarritos(Carrito carrito) {
		
		Carrito cli = daoCarrito.read(carrito.getCodigo_carrito());
		if(cli!= null) {
			daoCarrito.update(carrito);	
		}else {
			daoCarrito.insert(carrito); 
		}
		
	}
	
	public void actualizarCarrito(Carrito carrito) throws Exception {
		Carrito cli = daoCarrito.read(carrito.getCodigo_carrito());
		if (cli != null){
			daoCarrito.update(carrito);
		}else {
			throw new Exception("Carrito no existe");
		}
	}
	
	
	public void borrarCarrito(int codigo) {
		
		daoCarrito.remove(codigo); 
	}
	
	public List<Carrito> getCarritos(){
		return daoCarrito.getAll();
	}
	
	
	public Carrito getCarritoPorCodigo(int codigo) {
		return daoCarrito.getCarritoPorCodigo(codigo);
	}
}
