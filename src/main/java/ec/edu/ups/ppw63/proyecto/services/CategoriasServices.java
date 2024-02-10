package ec.edu.ups.ppw63.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.business.GestionCategorias;
import ec.edu.ups.ppw63.proyecto.model.Categoria;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categorias")
public class CategoriasServices {

	@Inject
	private GestionCategorias gCategorias;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Categoria> categorias = gCategorias.getCategorias();
		if(categorias.size()>0)
			return Response.ok(categorias).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran categorias");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
}
