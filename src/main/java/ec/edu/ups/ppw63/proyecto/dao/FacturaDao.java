package ec.edu.ups.ppw63.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Factura;
import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Factura factura) {
		em.persist(factura);
		
	}
	
	
	public void update(Factura factura) {
		em.merge(factura);
			
	}
	
	public void remove(int codigo) {
		Factura factura = em.find(Factura.class, codigo);
		em.remove(factura);
		
	}
	
	public Factura read (int codigo) {
		Factura factura = em.find(Factura.class, codigo);
		
		return factura;
		
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT F FROM Factura F";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Factura.class);
		return q.getResultList();
	}
	
	
	
	//ESTE PARA TRAER LA FACTURA POR NUMERO DE LA FACTURA
		public Factura getFacturaPorNumero(String numero) {
			String jpql = "SELECT f FROM Factura f WHERE f.numero_factura = :numero";
		    Query query = em.createQuery(jpql, Carrito.class);
		    query.setParameter("numero", numero);
		    List<Factura> facturas = query.getResultList();
		    if(facturas.size()>0)
		    	return facturas.get(0);
		    return null;
		}
		
	
	//ESTE TRAE TODAS LAS FACTURAS DE UN CLIENTE EN CONCRETO
		public List<Factura> getFacturasConDetallesPorCliente(String cedulaCliente) {
		    String jpql = "SELECT DISTINCT f FROM Factura f JOIN f.cliente c LEFT JOIN f.detalles d WHERE c.cedula_cliente = :cedulaCliente";
		    Query query = em.createQuery(jpql, Factura.class);
		    query.setParameter("cedulaCliente", cedulaCliente);
		    return query.getResultList();   
		}
		
		
	
}
