package com.deepu.app;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepu.model.AnswerTable;
import com.deepu.model.QuestionTable;
import java.util.List;

public class OneToManyMapping {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		config = new Configuration();
		session = config.configure().addAnnotatedClass(QuestionTable.class).addAnnotatedClass(AnswerTable.class).buildSessionFactory().openSession();
		
//		QuestionTable q1=new QuestionTable();
//		q1.setId(1);
//		q1.setQuestion("What is HIbernate");
//		
//		AnswerTable a1=new AnswerTable();
//		a1.setId(1);
//		a1.setAnswer("ORM framework");
//		a1.setQuestionTable(q1);  // many to one
//		
//		AnswerTable a2=new AnswerTable();
//		a2.setId(2);
//		a2.setAnswer("Implementation of JPA");
//		a2.setQuestionTable(q1);
//		
//		List<AnswerTable> answers=new ArrayList<>();
//		answers.add(a1);
//		answers.add(a2);
//		
//		q1.setAnswerList(answers);
		
		QuestionTable question=session.get(QuestionTable.class, 1);
		System.out.println(question.getQuestion());
		
		for(AnswerTable answers:question.getAnswerList()) {
			System.out.println(answers.getAnswer());
		} 
		
		try {

//			transaction = session.beginTransaction();
//			session.persist(q1);
			

			flag = true;

		} catch (HibernateException e) {
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

		}

	}

}
