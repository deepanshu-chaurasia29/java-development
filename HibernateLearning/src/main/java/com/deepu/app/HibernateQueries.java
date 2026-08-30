package com.deepu.app;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepu.model.Employee;
import com.deepu.model.Student;

public class HibernateQueries {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		// addAnotatedClass() -> this method handles the mapping. So, no need to map
		// through xml file.
		Session session1 = null;
		Session session2 = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session1 = sessionFactory.openSession();
			session2 = sessionFactory.openSession();
			transaction = session1.beginTransaction();

//			 Student st=new Student();
//			 st.setsId(1);
//			 st.setsName("Harsh");
//			 st.setsCity("Jaipur"); 

			// session.save(st); // to save the current object ,but its is deprecated
			// session.persist(st); // better method to save
			// session.save(st); // deprecated method
			// session.merge(st); // to store the current session object
			// session.saveOrUpdate(st); // deprecated method
			// session.delete(st); // this will delete the current student data
			// session.remove(st); // better way to delete records from table

//			Employee emp=new Employee(3,"Sneha","Patna");
//			emp.seteCity("Noida");
//			emp.seteId(1);
//			emp.seteName("Mohit");
//			session.persist(emp);
//			session.persist(st);

			// Student std2 = session.get(Student.class, 44); // get() method eagerly load the data -> for eagrly loading
															// first it will retrieve object from data base
			// Student std2=session.load(Student.class, 1);  // load method is deprecated
			// Student std2=session.getReference(Student.class, 33);  // getReference() method
			// lazy load the data -> no actual object was created until use case

			// if (std2 != null) {
				// System.out.println("Id is " + std2.getsId()); // this will be printed via proxy object but when I want
																// to print std2 name or city, Hibernate will create new
																// Object (bckz prosy object only have ID, it does not
																// have info about other columns) which will be actual
																// object and from there, it will print name and city.
																// That's why constructor is called 2 times
				// System.in.read(); // if object does not contains name or city stop here
				// System.out.println("Name is " + std2.getsName());
				// System.out.println("City is " + std2.getsCity());
			// } else {
				// System.out.println("There is no data at the given ID");
			// }
			
			// L1 caching
//			Student std1=session1.get(Student.class, 1);
//			System.out.println(std1);
//			Student std2=session1.get(Student.class, 1);
//			System.out.println(std2);
//			
//			Student std3=session2.get(Student.class, 1);
//			System.out.println(std3);
//			Student std4=session2.get(Student.class, 1);
//			System.out.println(std4);
			
			// L2 caching -> Not available in hibernate.for this, use 3rd party implementation, i.e, ehcache. 
			
			Student std1=session1.get(Student.class, 1);
			System.out.println(std1);
			Student std2=session1.get(Student.class, 2);
			System.out.println(std2);
			
			Student std3=session2.get(Student.class, 2);
			System.out.println(std3);
			Student std4=session2.get(Student.class, 1);
			System.out.println(std4);
			
			

			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			session1.close();
			session2.close();
			sessionFactory.close();
		}
	}

}
