package com.chenga.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.chenga.entites.BookingHistory;
import com.chenga.entites.Bus;

import com.chenga.entites.UserRegistration;

import com.chenga.model.BookingResponseModel;
import com.chenga.model.Login;

public class BusService {
	
	
	
	SessionFactory factory=null;
	
	public BusService() {
		HibernateUtil util=new HibernateUtil();
		 factory = util.sessionFactory();
	}
	
	
	public Bus addBus(Bus bus) {
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		
		Serializable save = session.save(bus);
		
		
		tx.commit();
		
		
		System.out.println(save);
		
		return bus;
	}
	
	
	public BookingResponseModel updateBusBooking(Bus bus,String mobile) {
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		
		float price=0.0f;
		String seatNumber="";
		
		
		String alreadyBookTicketsDisplay = alreadyBookTicketsDisplay(bus.getFromroute(),bus.getBusnumber());
		
		String str[]=alreadyBookTicketsDisplay.split(",");
		System.out.println("not working");
		System.out.println(Arrays.toString(str) +" already booking tikets ");
		
	
		if(bus.isSeat1()==true) {
			if(anyMatch(str, "seat1")){
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat1,";
			}
		}
		if(bus.isSeat2()==true) {
			
			if(anyMatch(str, "seat2")){  //if any match seat2 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat2,";
			}
		}
		if(bus.isSeat3()==true) {
			if(anyMatch(str, "seat3")){  //if any match seat2 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat3,";
			}
		}
		if(bus.isSeat4()==true) {
			if(anyMatch(str, "seat4")){  //if any match seat4 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat4,";
			}
		}
		
		if(bus.isSeat5()==true) {
			if(anyMatch(str, "seat5")){  //if any match seat5 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat5,";
			}
		}
		
		if(bus.isSeat6()==true) {
			if(anyMatch(str, "seat6")){  //if any match seat6 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat6,";
			}
		}
		
		if(bus.isSeat7()==true) {
			if(anyMatch(str, "seat7")){  //if any match seat7 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat7,";
			}	
		}
		
		if(bus.isSeat8()==true) {
			if(anyMatch(str, "seat8")){  //if any match seat8 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat8,";
			}
		}
		
		if(bus.isSeat9()==true) {
			if(anyMatch(str, "seat9")){  //if any match seat9 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat9,";
			}
		}
		
		if(bus.isSeat10()==true) {
			if(anyMatch(str, "seat10")){  //if any match seat10 
				
			}
			else {
				price+=500.40;
				seatNumber+=" Seat10";
			}
		}
		
	
		// check login Status 
		LogOutUtil l=new LogOutUtil();
		boolean loginStatus = l.checkLoginStatus(mobile);
		// check price based on user wallet amount
		
		boolean checkBalance = l.checkBalance(mobile,new BigDecimal(price));
		
		
		// get User Details based on mobile
		UserRegistration user = l.getUser(mobile);
		
		BookingResponseModel bookingModel=new BookingResponseModel();
		if(loginStatus==true && checkBalance==true) {
			// update Bus for Booking
			session.update(bus);
			
			tx.commit();
			
			System.out.println(bus);
			
			
			String seatNumbers="Seat Number["+seatNumber+"]";
			LocalDateTime time=LocalDateTime.now();
			bookingModel=new BookingResponseModel(mobile,user.getName(),user.getRegId(),seatNumbers,price,time.toString(),bus.getFromroute(),bus.getToroute());
		
			
			Session ss=factory.openSession();
			Transaction tran=ss.beginTransaction();
			
			
			
			BookingHistory history=new BookingHistory();
			history.setMobile(bookingModel.getMobile());
			history.setName(bookingModel.getName());
			history.setCreateAt(bookingModel.getCreateAt());
			history.setFromCity(bookingModel.getFromCity());
			history.setPrice(bookingModel.getPrice());
			history.setRegId(bookingModel.getRegId());
			history.setSeatNumber(bookingModel.getSeatNumber());
			history.setToCity(bookingModel.getToCity());
			
			
			Serializable save = ss.save(history);
			tran.commit();
			System.out.println("save the Booking Response Model "+save);
			
		}
			
		
		return bookingModel;
	}
	
	
	
	public List<Bus> getBuses(){
		Session session=factory.openSession();
		Query createQuery = session.createQuery("from Bus");
		
		List<Bus> list = createQuery.getResultList();
		
		return list;
		
	}
	
	public List<Bus> getBusesFromAndTo(String from,String to){
		
		Session session=factory.openSession();
		Query createQuery = session.createQuery("from Bus b where fromroute=:fromroute and toroute=:toroute");
		createQuery.setParameter("fromroute", from);
		createQuery.setParameter("toroute", to);
		
		List<Bus> list = createQuery.getResultList();
		System.out.println(list);
		
		
		// body of count available seats 
		
		
		return list;
	}
	
	
	public boolean loginCheck(Login login) {
		
		Session session=factory.openSession();
		
		Query createQuery = session.createQuery("from UserRegistration b where mobile=:mobile and password=:password");
		createQuery.setParameter("mobile", login.getMobile());
		createQuery.setParameter("password", login.getPassword());
		
		List<UserRegistration> resultList = createQuery.getResultList();
		
		UserRegistration userRegistration = resultList.get(0);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		if(userRegistration.getMobile().equalsIgnoreCase(login.getMobile()) &&  userRegistration.getPassword().equalsIgnoreCase(login.getPassword()) )
		{
			
			UserRegistration user=resultList.get(0);
			System.out.println("change login status "+user);
			
			Query cq = s.createQuery("update UserRegistration set loginStatus=true  where mobile=:mobile and password=:password");
			cq.setParameter("mobile", login.getMobile());
			cq.setParameter("password", login.getPassword());
			
			int executeUpdate = cq.executeUpdate();
			System.out.println(executeUpdate+" updated login status ");
			tx.commit();
			
			
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	
	public String alreadyBookTicketsDisplay(String fromRoute,int busnumber) {
		
		Session s1=factory.openSession();
		Query cq = s1.createQuery("from Bus where fromroute=:fromroute and busnumber=:busnumber ");
		cq.setParameter("fromroute", fromRoute);
		cq.setParameter("busnumber", busnumber);
		
		List<Bus> resultList = cq.getResultList();
		
		Bus bus = resultList.get(0);
		
		String seats="";
		
			
		
		
		if(bus.isSeat1()==true) {
			seats+="seat1,";
		}
		if(bus.isSeat2()==true) {
			seats+="seat2,";
		}
		if(bus.isSeat3()==true) {
			seats+="seat3,";
		}
		if(bus.isSeat4()==true) {
			seats+="seat4,";
		}
		if(bus.isSeat5()==true) {
			seats+="seat5,";
		}
		if(bus.isSeat6()==true) {
			seats+="seat6,";
		}
		if(bus.isSeat7()==true) {
			seats+="seat7,";
		}
		if(bus.isSeat8()==true) {
			seats+="seat8,";
		}
		if(bus.isSeat9()==true) {
			seats+="seat9,";
		}
		if(bus.isSeat10()==true) {
			seats+="seat10";
		}
		
		System.out.println("Already Booking Seats "+seats);
		
		return seats;
	}

	
	
	
	
	public boolean anyMatch(String s[], String seatNo) {
		
		return Arrays.stream(s).anyMatch(str->str.equalsIgnoreCase(seatNo));
	}
	
	public Bus getBusById(int busnumber) {
		
		Session session=factory.openSession();
		
		Query createQuery = session.createQuery("from Bus b where busnumber=:busnumber");
		createQuery.setParameter("busnumber", busnumber);
		
		List<Bus> resultList = createQuery.getResultList();
		
		Bus bus = resultList.get(0);
		
		return bus;
		
	}
	
	
	
		public List<BookingHistory> getBookingHistory(String mobile) {
		
		Session session=factory.openSession();
		
		Query createQuery = session.createQuery("from BookingHistory b where mobile=:mobile");
		createQuery.setParameter("mobile", mobile);
		
		List<BookingHistory> bookingHistory = createQuery.getResultList();
		
		
		
		return bookingHistory;
		
	}
	
	}
