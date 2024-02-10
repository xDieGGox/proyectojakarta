package ec.edu.ups.ppw63.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.business.GestionDetalles;
import ec.edu.ups.ppw63.proyecto.model.Detalle;
import ec.edu.ups.ppw63.proyecto.model.Item;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("detalles")
public class DetallesServices {
	
	@Inject
	private GestionDetalles gDetalles;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Detalle detalle) {
		try {
			System.out.println("DETALLE ENVIADO: "+detalle);
			gDetalles.guardarDetalles(detalle); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listaDetalles")
	public Response getClientes(@QueryParam("codigo")int codigoFactura){
		List<Detalle> detalles = gDetalles.getDetallesporCodigoFactura(codigoFactura);
		if(detalles.size()>0)
			return Response.ok(detalles).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
