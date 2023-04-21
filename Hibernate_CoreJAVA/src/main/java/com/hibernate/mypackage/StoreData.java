package com.hibernate.mypackage;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		
		Transaction t=session.beginTransaction();
		//Getting Result
		/*
		 * Query q=session.createQuery("from Employee"); List l=q.list();
		 */		
		Employee e1 =new Employee();
		e1.setId(125);
		e1.setFirstName("Deepa Krishnan");
		e1.setLastName("R");
		
		Employee e2=new Employee();
		e2.setId(131);
		e2.setFirstName("Arun Kumar");
		e2.setLastName("Ramar");
		
		Employee e4=new Employee();
		e4.setId(102);
		e4.setFirstName("Arun Kumar");
		e4.setLastName("Ram");
		
		//update 
		Query q1=session.createQuery("update Employee set lastName=:n where id=:i");
		q1.setParameter("n", e4.getLastName());
		q1.setParameter("i", e4.getId());
		
		int status = q1.executeUpdate();
		System.out.println(status);
		
		//delete
		Employee e3=session.get(Employee.class, 124);
		if(e3!=null)
		{
			session.delete(e3);
			System.out.println("Employee data was Deleted ");
		}
		
		
		session.save(e1);
		session.save(e2);
		Query q=session.createQuery("from Employee");
		List l=q.list();

		t.commit();
		System.out.println("Successfully Saved");
		
		Iterator<Employee> itr=l.iterator();
		while(itr.hasNext())
		{
			Employee e=itr.next();
			System.out.println("ID:"+e.getId());
			System.out.println("First Name:"+e.getFirstName());
			System.out.println("Last Name:"+e.getLastName());
		}
		
		
		factory.close();
		session.close();

	}

}
