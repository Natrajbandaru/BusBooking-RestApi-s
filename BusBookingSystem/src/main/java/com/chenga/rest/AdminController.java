package com.chenga.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chenga.entites.Bus;
import com.chenga.util.BusService;

@Path("/admin")
public class AdminController {

	BusService busService=new BusService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Bus addBus(Bus bus) {
	
		return busService.addBus(bus);
	}
}
