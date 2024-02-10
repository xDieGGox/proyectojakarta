package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Categoria categoria) {
		em.persist(categoria);
		
	}
	
	public void update(Categoria categoria) {
		em.merge(categoria);
			
	}
	
	public void remove(int codigo) {
		Categoria categoria = em.find(Categoria.class, codigo);
		em.remove(categoria);
		
	}
	
	public Categoria read (int codigo) {
		Categoria categoria = em.find(Categoria.class, codigo);
		
		return categoria;
		
	}
	
	public List<Categoria> getAll(){
		String jpql = "SELECT c FROM Categoria c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Categoria.class);
		return q.getResultList();
	}
}
