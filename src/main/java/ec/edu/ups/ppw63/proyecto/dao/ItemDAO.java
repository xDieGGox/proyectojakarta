package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ItemDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Item item) {
		em.persist(item);
		
	}
	
	public void update(Item item) {
		em.merge(item);
			
	}
	
	public void remove(int codigo) {
		Item item = em.find(Item.class, codigo);
		em.remove(item);
		
	}
	
	public Item read (int codigo) {
		Item item = em.find(Item.class, codigo);
		
		return item;
		
	}
	
	public List<Item> getAll(){
		String jpql = "SELECT c FROM Item c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Item.class);
		return q.getResultList();
	}
	
	
	
	 // Método para obtener todos los items de un carrito por su código
	public List<Item> getItemsByCarrito(int codigoCarrito) {
	    String sql = "SELECT * FROM Item WHERE carrito_codigo_carrito = :codigoCarrito";
	    Query q = em.createNativeQuery(sql, Item.class);
	    q.setParameter("codigoCarrito", codigoCarrito);
	    return q.getResultList();
	}
   
}
