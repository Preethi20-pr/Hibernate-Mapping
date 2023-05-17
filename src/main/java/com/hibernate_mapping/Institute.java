package com.hibernate_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import javax.persistence.Query;
public class Institute {
	 
public static void main(String args[]) {
	
	Configuration con=new Configuration().configure().addAnnotatedClass(Professor.class).addAnnotatedClass(Courses.class);
	SessionFactory sef=con.buildSessionFactory();
	Session ses=sef.openSession();
	Transaction tr=ses.beginTransaction();
	
	
	//creating courses data
	Courses c1=new Courses();
	c1.setCourseId(201);
	c1.setCourseName("Java");
	
    Courses c2=new Courses();
    c2.setCourseId(202);
	c2.setCourseName("MySQL");
	
	Courses c3=new Courses();
	c3.setCourseId(203);
    c3.setCourseName("Hibernate");
	
	//listing courses in one list
    List<Courses>l1=new ArrayList<>();
	l1.add(c3);
	l1.add(c2);


	List<Courses>l2=new ArrayList<>();
	l2.add(c1);
	l2.add(c3);
    l2.add(c2); 
	
	List<Courses>l3=new ArrayList<>();
	l3.add(c2);
	
	
	//creating professor data
	Professor p1=new Professor();
	p1.setProfessorId(1001);
	p1.setProfessorName("Bhaskara");
	p1.setProfessorLocation("Vizag");
	p1.setCrs(l2);
	
	Professor p2=new Professor();
	p2.setProfessorId(2002);
	p2.setProfessorName("Nafisa");
	p2.setProfessorLocation("Hyd");
	p2.setCrs(l1);
	
	Professor p3=new Professor();
	p3.setProfessorId(3003);
	p3.setProfessorName("James");
	p3.setProfessorLocation("KPHB");
	p3.setCrs(l3);
	  
	//inserting data 
	ses.save(c1);
    ses.save(c2);
	ses.save(c3);
	ses.save(p1);
	ses.save(p2);
	ses.save(p3);
	
	
	//to fetch data from db
	Query qu=ses.createQuery("from Professor");
	List<Professor> proflist=qu.getResultList();
	
	//to fetch list of Courses from Professor
	for(Professor p:proflist)
	{
		List<Courses>crs=p.getCrs();
		for(Courses c:crs)
		{
			System.out.println(p.getProfessorName()+" teaches "+c.getCourseName()+ " language");
		}
	}
	
	tr.commit();
}
}
