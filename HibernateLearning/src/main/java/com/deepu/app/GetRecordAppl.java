package com.deepu.app;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.deepu.model.Student;

public class GetRecordAppl {

	public static void main(String[] args) {

		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		// I am retrieving data here. So no need to create transaction
		Session session=null;
		
		try {
			session=sf.openSession();
			Student std=session.get(Student.class,2);  // get method retrieve one record of table
			System.out.println(std);
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
