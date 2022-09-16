package com.chenga.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.chenga.entites.Bus;
import com.chenga.model.BookingResponseModel;
import com.chenga.model.Login;
import com.chenga.model.LoginResponse;
import com.chenga.util.BusService;

@Path("login")
public class LoginController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginResponse logincheck(Login login)
	{
		System.out.println("Login controlller "+login);
		BusService busService=new BusService();

		boolean loginCheck = busService.loginCheck(login);
	
		System.out.println(loginCheck+" from login controll ");

		LoginResponse res=new LoginResponse();
		
		if(loginCheck==true) {
			
	        
	        res=new LoginResponse();
	        
	        res.setMessage(true);
	        res.setMobile(login.getMobile());
	        
		}
		
		return res;
	}
	
	

}
