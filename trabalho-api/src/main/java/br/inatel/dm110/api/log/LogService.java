package br.inatel.dm110.api.log;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/log")
public interface LogService {
	
	@GET
	@Path("{code}")
	@Produces(MediaType.APPLICATION_JSON)
	List<LogTO> listLogsByProductCode(@PathParam("code") int code);	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<LogTO> listLogs();
	
}
