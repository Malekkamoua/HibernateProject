package com.tn.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tn.Hibernate.HibernateUtil;
import com.tn.beans.Message;

public class MessageDAO extends DAO<Message> {

	public MessageDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public boolean create(Message ms) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ms);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	};

	public boolean update(int id, String new_text) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Message message = find(id);
			message.setText(new_text);
			session.update(message);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	public Message find(int idMessage) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Message ms = null;
		try {
			tx = session.beginTransaction();
			ms = (Message) session.get(Message.class, idMessage);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return ms;
	}

	public boolean delete(int idMessage) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Message ms = (Message) session.get(Message.class, idMessage);
			if (ms != null) {
				session.delete(ms);
				System.out.println("message is deleted");
			}

			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
}