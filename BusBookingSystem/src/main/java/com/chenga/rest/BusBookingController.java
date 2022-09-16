package com.chenga.rest;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.chenga.entites.Bus;
import com.chenga.entites.BusSeats;
import com.chenga.model.BookingResponseModel;
import com.chenga.model.BusBookingRequestModel;
import com.chenga.model.LoginResponse;
import com.chenga.util.BusService;

@Path("busbooking/{mobile}")
public class BusBookingController {
	
	BusService busService=new BusService();
	
	
 
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookingResponseModel displaySeats(@PathParam("mobile") String mobile,Bus bus) {
		
		
		
		System.out.println("Booking Controller "+bus);
		
		LoginResponse loginResponse=new LoginResponse();
		
		/*
		HttpSession session=req.getSession(false);
		String mobile=(String)session.getAttribute("mobile");
		*/
		
	
		System.out.println("Booking controller "+mobile);
		
			return  busService.updateBusBooking(bus,mobile);
	}
	
}
