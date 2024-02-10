package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.ProductoDAO;
import ec.edu.ups.ppw63.proyecto.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProductos {
	
	@Inject
	private ProductoDAO daoProducto;
	
	
	public void guardarProductos(Producto producto) {

		Producto cli = daoProducto.read(producto.getCodigo_producto());
		if(cli!= null) {
			daoProducto.update(producto);	
		}else {
			daoProducto.insert(producto); 
		}
		
	}
	
	public void actualizarProducto(Producto producto) throws Exception {
		Producto cli = daoProducto.read(producto.getCodigo_producto());
		if (cli != null){
			daoProducto.update(producto);
		}else {
			throw new Exception("Producto no existe");
		}
	}
	
	
	public void borrarProducto(int codigo) {
		
		daoProducto.remove(codigo); 
	}
	
	public List<Producto> getProductos(){
		return daoProducto.getAll();
	}
}
