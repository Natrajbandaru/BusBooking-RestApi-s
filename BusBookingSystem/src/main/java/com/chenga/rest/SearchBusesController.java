package com.chenga.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.chenga.entites.Bus;
import com.chenga.model.BusResponse;
import com.chenga.model.BusSearchModel;
import com.chenga.util.BusService;
import com.chenga.util.SeatsUtil;

@Path("searchbuses/")
public class SearchBusesController {

	BusService busService=new BusService();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<BusResponse> getBusesFromAndTo(BusSearchModel model){
		List<Bus> busesFromAndTo = busService.getBusesFromAndTo(model.getFrom(), model.getTo());
		System.out.println(busesFromAndTo);
		
		SeatsUtil seat=new SeatsUtil();
		List<BusResponse> displayAvaibleSeats = seat.displayAvaibleSeats(busesFromAndTo);
		
		System.out.println("Search Buses Controller "+displayAvaibleSeats);
		
		return displayAvaibleSeats;
	}
	

}
