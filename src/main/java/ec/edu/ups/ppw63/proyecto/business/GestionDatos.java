package ec.edu.ups.ppw63.proyecto.business;


import java.util.List;

import ec.edu.ups.ppw63.proyecto.dao.CarritoDAO;
import ec.edu.ups.ppw63.proyecto.dao.CategoriaDAO;
import ec.edu.ups.ppw63.proyecto.dao.ClienteDAO;
import ec.edu.ups.ppw63.proyecto.dao.ItemDAO;
import ec.edu.ups.ppw63.proyecto.dao.ProductoDAO;
import ec.edu.ups.ppw63.proyecto.model.CantidadCarritosCliente;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Categoria;
import ec.edu.ups.ppw63.proyecto.model.Cliente;
import ec.edu.ups.ppw63.proyecto.model.Item;
import ec.edu.ups.ppw63.proyecto.model.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
	private CarritoDAO daoCarrito;
	
	@Inject
	private ItemDAO daoItem;
	
	
	@PostConstruct
	public void init() {
		System.out.println("INICIANDO PROGRAMA");
		
		
		Categoria cat = new Categoria();
		cat.setNombre("Portatiles");
		
		daoCategoria.insert(cat); 
		
		 
		
		Cliente cliente1 = new Cliente();
		cliente1.setCedula_cliente("0107323180");
		cliente1.setNombre_cliente("DIEGO LOJA");
		cliente1.setCorreo_cliente("diegoloja85@gmail.com");
		cliente1.setClave_cliente("12345");
		cliente1.setDireccion_cliente("Cristo del Consuelo"); 
		
		daoCliente.insert(cliente1); 
		
		
		// Insertar un nuevo producto
        Producto producto1 = new Producto();
        producto1.setNombre_producto("Laptop HP");
        producto1.setImagen_producto("URL DE LA IMAGEN");
        producto1.setPrecio_producto(800.0);
        producto1.setCategoria(cat); 
        daoProducto.insert(producto1);
        
     // Insertar un nuevo producto
        Producto producto2 = new Producto();
        producto2.setNombre_producto("Celular SMS");
        producto2.setImagen_producto("URL DE LA IMAGEN 2");
        producto2.setPrecio_producto(600.0);
        producto2.setCategoria(cat); 
        daoProducto.insert(producto2);
        
        
     // Crear un carrito y asociarlo a un cliente
        Carrito carrito = new Carrito();
        carrito.setCliente(cliente1);
       
        
     // Crear un ítem de carrito y asociarlo a un producto y carrito
        Item itemCarrito = new Item();
        itemCarrito.setCantidad_item(5);
        itemCarrito.setProducto(producto1);
        
        carrito.addItem(itemCarrito); 
        
        itemCarrito = new Item();
        itemCarrito.setCantidad_item(4);
        itemCarrito.setProducto(producto2);
        
        carrito.addItem(itemCarrito); 
        
        
        daoCarrito.insert(carrito);
        
        
        System.out.println("\n------------- Cantidad FActuras");
		List<CantidadCarritosCliente> list3 = daoCarrito.getTotalCarritos();
		for (CantidadCarritosCliente carr: list3) {
			System.out.println(carr);
		}
        
        
        
	}
}
