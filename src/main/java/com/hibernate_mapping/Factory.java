package com.hibernate_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import javax.persistence.Query;
public class Factory {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Worker.class).addAnnotatedClass(Location.class);
		SessionFactory sf=con.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr= ses.beginTransaction();
		
		//creating location details
		Location loc1= new Location();
		loc1.setLocationId(1001);
	    loc1.setLocationPlace("Hyd");
	    loc1.setLocationState("Telangana");
	    
    Location loc2= new Location();
		loc2.setLocationId(1002);
	    loc2.setLocationPlace("Vizag");
	    loc2.setLocationState("Andhra");
	    
		
	//creating worker details and setting MANY worker To ONE location
	    Worker w1=new Worker();
		w1.setWorkerId(1);
		w1.setWorkerName("Preethi");
		w1.setWorkerField("Fullstack Developer");
		w1.setLoc(loc1);
		
		Worker w2=new Worker();
		w2.setWorkerId(2);
		w2.setWorkerName("Sudha");
		w2.setWorkerField("Data Analyst");
		w2.setLoc(loc1);
		
		Worker w3=new Worker();
		w3.setWorkerId(3);
		w3.setWorkerName("Bhavani");
		w3.setWorkerField("Frontend Developer");
		w3.setLoc(loc2);
		
		Worker w4=new Worker();
		w4.setWorkerId(4);
		w4.setWorkerName("Bindu");
		w4.setWorkerField("Fullstack Developer");
		w4.setLoc(loc2);
		
		//inserting worker and location
		ses.save(w1);
		ses.save(w2);
		ses.save(w3);
		ses.save(w4);
		ses.save(loc1);
		ses.save(loc2);
		
		
		 tr.commit();
		 
		 //to fetch name location and field from worker
		 Query qu=ses.createQuery("from Worker");
		 List<Worker>workerlist=qu.getResultList();
		 for(Worker w:workerlist)
	     System.out.println(w.getWorkerName()+" from "+w.getLoc().getLocationPlace()+" working as " +w.getWorkerField());

	}

}