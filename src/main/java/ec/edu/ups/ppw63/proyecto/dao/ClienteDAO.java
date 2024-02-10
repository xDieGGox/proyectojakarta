package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
		
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
			
	}
	
	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
		
	}
	
	public Cliente read (int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		
		return cliente;
		
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	
	public Cliente getClientePorCorreo(String correo) {
		String jpql = "SELECT c FROM Cliente c WHERE c.correo_cliente=:correo";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("correo", correo);
		List<Cliente> clientes = q.getResultList();
		if(clientes.size()>0)
			return clientes.get(0);
		return null;
 	}
}
