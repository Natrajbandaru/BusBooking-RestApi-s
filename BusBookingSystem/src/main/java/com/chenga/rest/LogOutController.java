package com.chenga.rest;



import java.io.IOException;
import java.util.logging.FileHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenga.model.LogOutResponse;
import com.chenga.model.LoginResponse;
import com.chenga.util.LogOutUtil;

@Path("logout/{mobile}")
public class LogOutController {

	
	Logger logger=LoggerFactory.getLogger(LogOutController.class.getName());
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LogOutResponse logOut(@PathParam("mobile") String mobile) throws SecurityException, IOException {
		
		FileHandler handler=new FileHandler("E://loggers/logimple.txt",true);
	
		logger.debug("in this path User Mobile Number is "+mobile);
		
		System.out.println("logOut Controller mobile "+mobile);
		
		
		LogOutUtil  o=new LogOutUtil();
		boolean status = o.logOutUtil(mobile);
	
		LogOutResponse logOutResponse=new LogOutResponse();
		logOutResponse.setStatus(status);
		
		logger.info("to Send LogOutResponse to Client "+logOutResponse);
		return logOutResponse;
	}
}
