package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.CategoriaDAO;
import ec.edu.ups.ppw63.proyecto.model.Categoria;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCategorias {
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	
	
public void guardarCategorias(Categoria categoria) {
		
		Categoria cli = daoCategoria.read(categoria.getCodigo_categoria());
		if(cli!= null) {
			daoCategoria.update(categoria);	
		}else {
			daoCategoria.insert(categoria); 
		}
		
	}
	
	public void actualizarCategoria(Categoria categoria) throws Exception {
		Categoria cli = daoCategoria.read(categoria.getCodigo_categoria());
		if (cli != null){
			daoCategoria.update(categoria);
		}else {
			throw new Exception("Categoria no existe");
		}
	}
	
	
	public void borrarCategoria(int codigo) {
		
		daoCategoria.remove(codigo); 
	}
	
	public List<Categoria> getCategorias(){
		return daoCategoria.getAll();
	}
}


