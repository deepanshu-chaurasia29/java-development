package com.deepu.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepu.model.Courses;
import com.deepu.model.Students;


public class ManyToManyMapping {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Students.class).buildSessionFactory();
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		session=sessionFactory.openSession();
		Students st1=session.get(Students.class, 1);
		Students st2=session.get(Students.class, 2);
		Students st3=session.get(Students.class, 3);
		System.out.println(st1);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(st2);
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(st3);
		System.out.println("--------------------------------------------------------------------------");
		
		
//		Courses c1=new Courses();
//		c1.setId(101);
//		c1.setCourseName("Java");
//		c1.setCoursePrice("1000");
//		
//		Courses c2=new Courses();
//		c2.setId(102);
//		c2.setCourseName("Python");
//		c2.setCoursePrice("2000");
//		
//		Courses c3=new Courses();
//		c3.setId(103);
//		c3.setCourseName("C++");
//		c3.setCoursePrice("3000");
//		
//		Set<Courses> courseSet1=new HashSet<>();
//		courseSet1.add(c1);
//		courseSet1.add(c2);
//		courseSet1.add(c3);
//		
//		Set<Courses> courseSet2=new HashSet<>();
//		courseSet2.add(c1);
//		courseSet2.add(c2);
//		
//		
//		Students st1=new Students();
//		st1.setId(1);
//		st1.setName("Deepu");
//		st1.setCity("Jaipur");
//		st1.setCourses(courseSet1);
//		
//		Students st2=new Students();
//		st2.setId(2);
//		st2.setName("Sneha");
//		st2.setCity("Patna");
//		st2.setCourses(courseSet2);
//		
//		Students st3=new Students();
//		st3.setId(3);
//		st3.setName("Mohit");
//		st3.setCity("Noida");
//		st3.setCourses(courseSet1);
		
		
		try {
			
//			transaction = session.beginTransaction();
//			session.persist(st1);
//			session.persist(st2);
//			session.persist(st3);
			
			
			flag=true;
			
		}catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
//			if (flag) {
//				transaction.commit();
//			} else {
//				transaction.rollback();
//			}
			session.close();
			sessionFactory.close();
		}

	}

}
