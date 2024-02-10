package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Producto producto) {
		em.persist(producto);
		
	}
	
	public void update(Producto producto) {
		em.merge(producto);
			
	}
	
	public void remove(int codigo) {
		Producto producto = em.find(Producto.class, codigo);
		em.remove(producto);
		
	}
	
	public Producto read (int codigo) {
		Producto producto = em.find(Producto.class, codigo);
		
		return producto;
		
	}
	
	public List<Producto> getAll(){
		String jpql = "SELECT p FROM Producto p";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();
	}
	
}
