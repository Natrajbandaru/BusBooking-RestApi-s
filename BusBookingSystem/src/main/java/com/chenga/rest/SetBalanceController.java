package com.chenga.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chenga.model.Balance;
import com.chenga.util.SeatsUtil;

@Path("setbalance/{mobile}")
public class SetBalanceController {

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Balance addBalance(@PathParam("mobile") String mobile, Balance balance) {
			
		SeatsUtil seatUtil=new SeatsUtil();
		
		System.out.println(balance);
		
		Balance setBalance = seatUtil.setBalance(mobile, balance.getBalance());
		
		return setBalance;
	}
}
