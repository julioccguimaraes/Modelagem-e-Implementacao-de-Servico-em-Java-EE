package br.inatel.dm110.api.product;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
public interface ProductService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveProduct(ProductTO product);

	@GET
	@Path("{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductTO findProductByCode(@PathParam("code") int code);	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductTO> listProducts();
	
	@PUT
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateProduct(@PathParam("code") int code, ProductTO product);	
}
