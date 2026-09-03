package com.deepu.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepu.model.Answer;
import com.deepu.model.Question;
import com.deepu.model.Student;

public class HibernateAssociationMapping {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		config = new Configuration();
		session = config.configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class).buildSessionFactory().openSession();
		
		Question q1=new Question();
		q1.setId(1);
		q1.setQuestion("What is HIbernate");
		
		Answer a1=new Answer();
		a1.setId(1);
		a1.setAnswer("ORM framework");
		
		q1.setAnswer(a1);
		a1.setQuestion(q1);
		
		Question q2=new Question();
		q2.setId(2);
		q2.setQuestion("What is OOPs");
		
		Answer a2=new Answer();
		a2.setId(2);
		a2.setAnswer("Object oriented programming");
		
		q2.setAnswer(a2);
		a2.setQuestion(q2);
		
//		Question que1=session.get(Question.class, 1);
//		System.out.println(que1.toString());
		
		try {

			transaction = session.beginTransaction();
			session.persist(q1);
			session.persist(q2);
			
//			session.persist(a1);
//			session.persist(a2);
			

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

		}

	}

}
