package com.chenga;



import java.io.Serializable;
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
import com.chenga.util.HibernateUtil;

@Path("test")
public class MyResource1 {

	SessionFactory sessionFactory=null;
	
	 public MyResource1() {
		HibernateUtil util=new HibernateUtil();
		 sessionFactory = util.sessionFactory();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(UserRegistration reg) {
		
		UserRegistration userReg=new UserRegistration();
		userReg.setAge(reg.getAge());
		userReg.setDob(reg.getDob());
		userReg.setEmail(reg.getEmail());
		userReg.setGender(reg.getGender());
		userReg.setMobile(reg.getMobile());
		userReg.setName(reg.getName());
		userReg.setPassword(reg.getPassword());
		
		
		UUID userRegId=userReg.getRegId();
		
		
		
		userReg.setWallet(reg.getWallet());
		
		// session
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Serializable save = session.save(userReg);
		
		tx.commit();
		System.out.println(save);
		System.out.println(userReg.toString());
		return Response.ok(reg).build();
		
	}
}
