package com.deepu.app;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.deepu.model.Student;

public class FirstAppl 
{

	public static void main(String[] args) 
	{
		// step 1 - Create configuration object
		Configuration config=new Configuration();
		
		// step 2- configure hibernate.cfg.xml file to configuration object
		config.configure();  // if owr xml file name was different then i must mention that into configure section
		
		// Step 3 - create sessionFactory Object
		SessionFactory sessionFactory=config.buildSessionFactory();
		
		// Step 4 - get the session Object
		Session session=sessionFactory.openSession();
		
		// Step 5 - begin the transaction within session
		Transaction transaction=session.beginTransaction();
		
		Student std=new Student();
		std.setsId(1);
		std.setsName("Deepu");
		std.setsCity("Noida");
		
		// Step 6 - perform operation
		session.save(std);
		
		// step 7- perform transaction operation
		transaction.commit();
		
		// step 8 - close the session
		session.close();
		
		
		
		
		

	}

}
