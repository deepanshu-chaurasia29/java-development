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
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// addAnotatedClass() -> this method handles the mapping. So, no need to map through xml file.
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			 Student st=new Student();
			 st.setsId(1);
			 st.setsName("Harsh");
			 st.setsCity("Jaipur"); 
			
			// session.save(st);  // to save the current object  ,but its is deprecated
			// session.persist(st);  // better method to save
			// session.save(st);  // deprecated method
			// session.merge(st);  // to store the current session object
			// session.saveOrUpdate(st);  // deprecated method
			// session.delete(st);  // this will delete the current student data
			// session.remove(st);  // better way to delete records from table
			
			
			Employee emp=new Employee(3,"Sneha","Patna");
//			emp.seteCity("Noida");
//			emp.seteId(1);
//			emp.seteName("Mohit");
			session.persist(emp);
			session.persist(st);
			flag=true;
			
		}catch(HibernateException e ) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
	}

}
