package com.hibernate_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import javax.persistence.Query;

public class company {
	 
	public static void main(String[] args) {
		Configuration con=new Configuration().configure().addAnnotatedClass(employee.class).addAnnotatedClass(project.class);
		SessionFactory sf=con.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		
		//creating projects list
		project p1=new project();
		p1.setProjectId(1);
		p1.setProjectName("Hibernate Project");
		
		project p2=new project();
		p2.setProjectId(2);
		p2.setProjectName("SQL Project");
		
		project p3=new project();
		p3.setProjectId(3);
		p3.setProjectName("Java Project");
		 
		//listing projects
		List<project> projectlist =new ArrayList<project>();
		projectlist.add(p1);
		projectlist.add(p2);
		
		List<project> projectlist2=new ArrayList<project>();
		projectlist2.add(p3);
		 
		// creating employee and setting ONE employee TO MANY projects
		employee e1=new employee();
		e1.setEmpId(101);
		e1.setEmpName("Preethi");
		e1.setEmpLocation("Hyd");
		e1.setProject(projectlist);
		
		employee e2=new employee();
		e2.setEmpId(102);
		e2.setEmpName("bindu");
		e2.setEmpLocation("KPHB");
		e2.setProject(projectlist2);
		
		ses.save(p1);
		ses.save(p2);
		ses.save(p3);
		ses.save(e1);
		ses.save(e2);
		
		Query qu=ses.createQuery("from employee");
		
		//to get list of employee
		List<employee> emplist=qu.getResultList();
		
		for(employee emp:emplist) {
			 System.out.println("name:"+emp.getEmpName());
			
			 //to get list of projects of a employee
			List<project> pr=emp.getProject();
			for(project p:pr)
				System.out.println(emp.getEmpName()+" is  working with "+p.getProjectName());
		}
		tr.commit();
	}
}