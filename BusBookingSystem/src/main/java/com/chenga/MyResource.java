package com.chenga;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/myresource")
public class MyResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod() {
		Timestamp time=new Timestamp(System.currentTimeMillis());
		BigDecimal b=new BigDecimal(22.22222);
		
		Hello h=new Hello("Hello This hello class "," chengareddy",time,b);
		return Response.ok(h).build();
	}
}
