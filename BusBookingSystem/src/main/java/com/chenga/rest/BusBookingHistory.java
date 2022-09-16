package com.chenga.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chenga.entites.BookingHistory;
import com.chenga.model.LoginResponse;
import com.chenga.util.BusService;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("bookinghistory/{mobile}")
public class BusBookingHistory {

	BusService busService=new BusService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<BookingHistory> getBookingHistory(@PathParam("mobile") String mobile) {
		
		LoginResponse loginResponse=new LoginResponse();
		
		//String mobile="9491006073";
		
	
		System.out.println("BookingHistory controller mobile "+mobile);
		
	return  busService.getBookingHistory(mobile);
	}
	
	
}


