package com.chenga;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("date/{dateString}")
public class DateResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String myDate(@PathParam("dateString") MyDate mydate) {
		
		return "Go "+mydate.toString();
	}
}
