package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.FacturaDao;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFactura {
	
	@Inject
	private FacturaDao daoFactura;
	
	public void guardarFacturas(Factura factura) {
		
		Factura cli = daoFactura.read(factura.getCodigo_factura());
		if(cli!= null) {
			daoFactura.update(factura);	
		}else {
			daoFactura.insert(factura); 
		}
		
	}
	
	public void actualizarFactura(Factura factura) throws Exception {
		Factura cli = daoFactura.read(factura.getCodigo_factura());
		if (cli != null){
			daoFactura.update(factura);
		}else {
			throw new Exception("Factura no existe");
		}
	}
	
	
	public void borrarFactura(int codigo) {
		
		daoFactura.remove(codigo); 
	}
	
	public List<Factura> getFacturas(){
		return daoFactura.getAll();
	}
	
	public Factura getFacturaPorNumero(String numero) {
		return daoFactura.getFacturaPorNumero(numero);
	}
	
	
	public List<Factura> getFacturaPorCliente(String cedulaCliente){
		return daoFactura.getFacturasConDetallesPorCliente(cedulaCliente);
	}
	

}
