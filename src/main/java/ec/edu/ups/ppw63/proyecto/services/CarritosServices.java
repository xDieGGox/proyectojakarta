package ec.edu.ups.ppw63.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.business.GestionCarrito;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("carritos")
public class CarritosServices {
	
	@Inject
	private GestionCarrito gCarritos;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Carrito carrito) {
		try {
			gCarritos.guardarCarritos(carrito); //Estos son los metodos o servicios
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
	public Response getCarritoPorCodigo(@QueryParam("codigo")int codigo) {
		try {
			System.out.println("SIRVE EL METODO Y LE MANDO: "+ codigo);
			Carrito carr= gCarritos.getCarritoPorCodigo(codigo); //Estos son los metodos o servicios
			return Response.ok(carr).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build(); 
		}
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCarritos(){
		List<Carrito> carritos = gCarritos.getCarritos();
		if(carritos.size()>0)
			return Response.ok(carritos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran carritos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
