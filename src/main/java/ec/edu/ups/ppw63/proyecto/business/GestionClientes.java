package ec.edu.ups.ppw63.proyecto.business;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.ClienteDAO;
import ec.edu.ups.ppw63.proyecto.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;
	
	
	public void guardarClientes(Cliente cliente) {
		
		Cliente cli = daoCliente.read(cliente.getCodigo_cliente());
		if(cli!= null) {
			daoCliente.update(cliente);	
		}else {
			daoCliente.insert(cliente); 
		}
		
	}
	
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo_cliente());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}

	
	
	public Cliente getClientePorCorreo(String correo) throws Exception{
		return daoCliente.getClientePorCorreo(correo); 
	}
	
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	
	
	
	

	
	
	//ESTO ES DE LA TRANSFERENCIA

	public void writeCarrito(String dato) {
		System.out.println(dato);
	}
}
