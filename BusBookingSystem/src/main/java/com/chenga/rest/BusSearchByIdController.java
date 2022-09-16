package com.chenga.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.chenga.entites.Bus;
import com.chenga.util.BusService;

@Path("/booking/{busnumber}")
public class BusSearchByIdController {
	
	

	BusService busService=new BusService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Bus displayBusById(@PathParam("busnumber") int busnumber) {
			
						
			
		
		Bus bus = busService.getBusById(busnumber);	
		
		System.out.println(bus);
		return bus;
	}
	
}
