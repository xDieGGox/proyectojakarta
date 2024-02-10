package ec.edu.ups.ppw63.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.business.GestionProductos;
import ec.edu.ups.ppw63.proyecto.model.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("productos")
public class ProductosServices {
	
	@Inject
	private GestionProductos gProductos;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Producto producto) {
		try {
			gProductos.guardarProductos(producto); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(cliente).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getProductos(){
		List<Producto> productos = gProductos.getProductos();
		if(productos.size()>0)
			return Response.ok(productos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran productos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
