package ec.edu.ups.ppw63.proyecto.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw63.proyecto.model.CantidadCarritosCliente;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CarritoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Carrito carrito) {
		em.persist(carrito);
		
	}
	
	public void addItem(Item item) {
		
	}
	
	public void update(Carrito carrito) {
		em.merge(carrito);
			
	}
	
	public void remove(int codigo) {
		Carrito carrito = em.find(Carrito.class, codigo);
		em.remove(carrito);
		
	}
	
	public Carrito read (int codigo) {
		Carrito carrito = em.find(Carrito.class, codigo);
		
		return carrito;
		
	}
	
	public List<Carrito> getAll(){
		String jpql = "SELECT c FROM Carrito c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Carrito.class);
		return q.getResultList();
	}
	
	//ESTE PARA TRAER EL CARRITO POR CODIGO DEL CLIENTE
	public Carrito getCarritoPorCodigo(int codigo) {
		String jpql = "SELECT c FROM Carrito c WHERE c.cliente.codigo_cliente = :codigo";
	    Query query = em.createQuery(jpql, Carrito.class);
	    query.setParameter("codigo", codigo);
	    List<Carrito> carritos = query.getResultList();
	    if(carritos.size()>0)
	    	return carritos.get(0);
	    return null;
	}
	
	
	//CONSULTA QUE TRAE LOS ITEMS DEL CARRITO
	
	
	
	
	//TRASNFERENCIAAA
	public List<CantidadCarritosCliente> getTotalCarritos() {
		String sql = "SELECT c.codigo_cliente, c.nombre_cliente, COUNT(ca.codigo_carrito) "
				+ "FROM Cliente c "
				+ "LEFT JOIN Carrito ca ON c.codigo_cliente = ca.codigo_cliente GROUP BY c.codigo_cliente, c.nombre_cliente";
		Query q = em.createNativeQuery(sql);
		List<Object[]> list = q.getResultList();
		List<CantidadCarritosCliente> datos = new ArrayList<CantidadCarritosCliente>();
		for(Object[] result: list) {
			datos.add(new CantidadCarritosCliente(((Number) result[0]).intValue(), 
					result[1].toString(), 
					((Number) result[2]).intValue()));
		}
		return datos;
	
	}
}
