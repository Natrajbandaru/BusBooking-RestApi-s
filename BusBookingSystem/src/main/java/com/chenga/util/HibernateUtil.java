package com.chenga.util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;    
import org.hibernate.boot.MetadataSources; 
import org.hibernate.boot.Metadata;

public class HibernateUtil {
	
	SessionFactory factory=null;
	public SessionFactory sessionFactory() {
		
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
		      
		    return factory=meta.getSessionFactoryBuilder().build();  
		      
		      
	}

}
