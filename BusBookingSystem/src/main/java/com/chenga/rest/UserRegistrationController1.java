package com.chenga.rest;



import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.chenga.entites.UserRegistration;
import com.chenga.entites.Wallet;
import com.chenga.model.UserRegResponse;
import com.chenga.model.UserRegistrationRequest;
import com.chenga.util.CalculateAge;
import com.chenga.util.HibernateUtil;

@Path("userregistration")
public class UserRegistrationController1 {

	SessionFactory sessionFactory=null;
	
	 public UserRegistrationController1() {
 
		HibernateUtil util=new HibernateUtil();
		 sessionFactory = util.sessionFactory();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(UserRegistrationRequest reg)  {
		
		UserRegistration userReg=new UserRegistration();
		
		
		UUID regid=UUID.randomUUID();
		LocalDateTime t=LocalDateTime.now();
		
		userReg.setRegId(regid.toString());
		userReg.setDob(reg.getDob());
		
		CalculateAge age=new CalculateAge();
		
		try {
			int currentAge = age.calculateAgeBasedOnDOB(reg.getDob());
			userReg.setAge(currentAge);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		userReg.setEmail(reg.getEmail());
		userReg.setGender(reg.getGender());
		userReg.setMobile(reg.getMobile());
		userReg.setName(reg.getName());
		userReg.setPassword(reg.getPassword());
		userReg.setLoginStatus(false);
		
		
		
		
		Wallet w=new Wallet();
		w.setRegId(t.toString());
		w.setBalance(new BigDecimal(reg.getWallet()));  
		w.setCreateAt(t);
		
		userReg.setWallet(w);
		
		// session
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Serializable save = session.save(userReg);
		
		tx.commit();
		System.out.println(save);
		System.out.println(userReg.toString());
			
		
		return Response.ok(userReg).build();
		
	}
}
