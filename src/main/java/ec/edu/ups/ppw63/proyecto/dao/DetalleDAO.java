package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Detalle;
import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Detalle detalle) {
		em.persist(detalle);
		
	}
	
	public void update(Detalle detalle) {
		em.merge(detalle);
			
	}
	
	public void remove(int codigo) {
		Detalle detalle = em.find(Detalle.class, codigo);
		em.remove(detalle);
		
	}
	
	public Detalle read (int codigo) {
		Detalle detalle = em.find(Detalle.class, codigo);
		
		return detalle;
		
	}
	
	public List<Detalle> getAll(){
		String jpql = "SELECT d FROM Detalle d";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Detalle.class);
		return q.getResultList();
	}
	
	
	
	 // Método para obtener todos los detalles de una factura por su código
	public List<Detalle> getDetallesByFactura(int codigoFactura) {
	    String sql = "SELECT * FROM Detalle WHERE factura_codigo_factura = :codigoFactura";
	    Query q = em.createNativeQuery(sql, Detalle.class);
	    q.setParameter("codigoFactura", codigoFactura);
	    return q.getResultList();
	}
	
	
}
