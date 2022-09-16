package com.chenga.util;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenga.entites.UserRegistration;

public class LogOutUtil {
	
	
	Logger logger=LoggerFactory.getLogger(LogOutUtil.class.getName());
	
	
	private SessionFactory factory=null;
	
	public LogOutUtil() {
		HibernateUtil util=new HibernateUtil();
		 factory = util.sessionFactory();
	}
	
	public boolean logOutUtil(String mobile) {
		
		logger.debug("User request to logout throught their mobile number "+mobile);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query cq = session.createQuery("update UserRegistration set loginStatus=false  where mobile=:mobile");
		cq.setParameter("mobile", mobile);
		
		int executeUpdate = cq.executeUpdate();
		logger.debug("To Check If This User is Existed Or Not ");
		if(executeUpdate==1) {
			logger.debug("These User is Existed  ");
			logger.debug("update the login status 1 to 0");
		}
		else
		{
			logger.debug("These User is Not Existed in DB");
			
		}
		
		System.out.println(executeUpdate+" updated login status ");
		tx.commit();
		
		if(executeUpdate==1) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
	public boolean checkLoginStatus(String mobile) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query cq = session.createQuery("from UserRegistration where mobile=:mobile");
		cq.setParameter("mobile", mobile);
		
		List<UserRegistration> resultList = cq.getResultList();
		
		UserRegistration registration = resultList.get(0);
		
		
		return registration.getLoginstatus();
	}
	
	
	
	public boolean checkBalance(String mobile,BigDecimal seatPrice) {
		
		boolean b=false;
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query cq = session.createQuery("from UserRegistration where mobile=:mobile");
		cq.setParameter("mobile", mobile);
		
		List<UserRegistration> resultList = cq.getResultList();
		
		UserRegistration registration = resultList.get(0);
		
		if(seatPrice.floatValue() < registration.getWallet().getBalance().floatValue()) {
			b=true;
		}
		else
		{
			b=false;
		}
		
		return b;
	}
	
	
	
	public UserRegistration getUser(String mobile) {
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query cq = session.createQuery("from UserRegistration where mobile=:mobile");
		cq.setParameter("mobile", mobile);
		
		List<UserRegistration> resultList = cq.getResultList();
		
		UserRegistration registration = resultList.get(0);
		
		
		
		return registration;
	}

}
