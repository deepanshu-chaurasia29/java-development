package com.deepu.app;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.deepu.model.Student;

public class HibernateConfiguration {

	public static void main(String[] args) {

		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session1 = null;
		Transaction transaction = null;
		boolean flag = false;
		config = new Configuration();

	
		// we are configuring through java code right now and removed config.configure() method
		// its not a good way
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/deepu_db");
//		config.setProperty("hibernate.connection.username", "root");
//		config.setProperty("hibernate.connection.password", "deepu@123");
//		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		config.setProperty("hibernate.hbm2ddl.auto", "update");
//		config.setProperty("hibernate.show_sql", "true");
//		config.setProperty("hibernate.format_sql", "true");
//		config.setProperty("hibernate.cache.use_second_level_cache", "true");
//		config.setProperty("hibernate.cache.region.factory_class",
//				"org.hibernate.cache.jcache.internal.JCacheRegionFactory");


		config.configure();
		session1 = config.addAnnotatedClass(Student.class).buildSessionFactory().openSession();
		Student std1 = new Student("Aman","Bihar");
//		std1.setsCity("Delhi");
//		std1.setsName("Aaryan");

		try {

			transaction = session1.beginTransaction();
			session1.persist(std1);

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

		}

	}

}
