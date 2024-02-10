package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.DetalleDAO;
import ec.edu.ups.ppw63.proyecto.model.Detalle;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionDetalles {
	
	@Inject
	private DetalleDAO daoDetalle;
	
	public void guardarDetalles(Detalle detalle) {
		
		Detalle det = daoDetalle.read(detalle.getCodigo_detalle());
		if(det!= null) {
			daoDetalle.update(detalle);	
		}else { 
			daoDetalle.insert(detalle); 
		}
		
	}
	
	public void actualizarDetalle(Detalle detalle) throws Exception {
		Detalle det = daoDetalle.read(detalle.getCodigo_detalle());
		if (det != null){
			daoDetalle.update(detalle);
		}else {
			throw new Exception("Detalle no existe");
		}
	}
	
	
	public void borrarDetalle(int codigo) {
		
		daoDetalle.remove(codigo); 
	}
	
	public List<Detalle> getDetalles(){
		return daoDetalle.getAll();
	}
	
	
	public List<Detalle> getDetallesporCodigoFactura(int codigoFactura){
		return daoDetalle.getDetallesByFactura(codigoFactura);
	}
	
}

