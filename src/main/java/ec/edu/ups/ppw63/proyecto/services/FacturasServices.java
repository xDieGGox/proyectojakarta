package ec.edu.ups.ppw63.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw63.proyecto.business.GestionFactura;
import ec.edu.ups.ppw63.proyecto.model.Carrito;
import ec.edu.ups.ppw63.proyecto.model.Factura;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("facturas")
public class FacturasServices {
	
	@Inject
	private GestionFactura gFacturas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Factura factura) {
		try {
			gFacturas.guardarFacturas(factura); //Estos son los metodos o servicios
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
	public Response getFacturaPorNumero(@QueryParam("numero")String numero) {
		try {
			System.out.println("SIRVE EL METODO Y LE MANDO: "+ numero);
			Factura fac= gFacturas.getFacturaPorNumero(numero); //Estos son los metodos o servicios
			return Response.ok(fac).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build(); 
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	@Path("listaFacCliente")
	public Response getFacturasPorCliente(@QueryParam("dni")String cedula) {
		try {
			System.out.println("SIRVE EL METODO Y LE MANDO: "+ cedula);
			List<Factura> fac= gFacturas.getFacturaPorCliente(cedula); //Estos son los metodos o servicios
			return Response.ok(fac).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build(); 
		}
	}
	
}
