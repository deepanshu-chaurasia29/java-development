package com.deepu.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepu.model.StudentInfo;

public class LOBs {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfo.class)
				.buildSessionFactory();
		Session session = null;
		session = sessionFactory.openSession();
		Transaction transaction = null;
		boolean flag = false;
		byte[] photo = null;
		char[] resume = null;
		FileInputStream fis = null;
		FileReader fr = null;

		try {
			fis = new FileInputStream("C:\\Users\\deepa\\git\\repository\\HibernateLearning\\files\\photo.jpg");
			photo = new byte[fis.available()]; // create a byte array of the size of the photo
			fis.read(photo); // read the photo into the byte array
			
			File file = new File("C:\\Users\\deepa\\git\\repository\\HibernateLearning\\files\\resume.txt");
			fr= new FileReader(file);
			resume=new char[(int) file.length()]; // create a char array of the size of the resume
			fr.read(resume); // read the resume into the char array

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		StudentInfo std1 = new StudentInfo();
		std1.setName("Deepu");
		std1.setPhoto(photo);
		std1.setResume(resume);

		try {
			transaction = session.beginTransaction();
			session.persist(std1);
			
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
			session.close();
			
			sessionFactory.close();
		}

	}

}
