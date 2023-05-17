package com.hibernate_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con=new Configuration().configure()
        		.addAnnotatedClass(student.class).addAnnotatedClass(bike.class);
        
        SessionFactory sf=con.buildSessionFactory();
        
        Session ses=sf.openSession();
        Transaction tr=ses.beginTransaction();
    	 
        //creating bikeId and bikeName
        bike b1=new bike();
        b1.setBikeId(101);
        b1.setBikeName("BMW");
    	
        bike b2=new bike();
        b2.setBikeId(102);
        b2.setBikeName("Innova");
         
        // creating studentsId name class and setting ONE bike TO ONE student
       student s1=new student();
       s1.setStId(1);
       s1.setStName("Jack");
       s1.setStClass("MBA");
       s1.setBike(b1);
       
       student s2=new student();
       s2.setStId(2);
       s2.setStName("Rose");
       s2.setStClass("MBA");
       s2.setBike(b2);
        
       //inserting bike and students
       ses.save(b1);
       ses.save(b2);
       ses.save(s1);
       ses.save(s2);
       tr.commit();
        
       //to fetch data from students
       Query qu=ses.createQuery("from student");
       
       
       List<student> ls=qu.getResultList();
       for(student s:ls)
       		System.out.println(s.getStName()+" has "+s.getBike().getBikeName());
       
    
    }
}
