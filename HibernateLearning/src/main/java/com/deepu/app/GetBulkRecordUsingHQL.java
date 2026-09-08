package com.deepu.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.deepu.model.Employee;


// To get all records of table we can use HQL query "FROM Employee" and getResultList() method will return all records of table in list format
public class GetBulkRecordUsingHQL {

	public static void main(String[] args) {

		SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		int count=0;
		
		try {
			session=sessionFactory.openSession();
			
			
			// Select query in HQL format
			
			// SELECT * FROM EmployeeTable;  // this is sql query
			// Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
			// List<Employee> listEmployee=query.list();
			
			// listEmployee.forEach(s->System.out.println(s));
			
			// Non-select query in HQL format
			transaction=session.beginTransaction();
			
			count=session.createQuery("UPDATE Employee SET eName= :name ").setParameter("name", "Deepu").executeUpdate();
			
			flag=true;
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("number of records updated: "+count);
			}else {
				transaction.rollback();
				System.out.println("number of records updated: "+count);
			}
			session.close();
			sessionFactory.close();
		}

	}

}
