package com.tn.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tn.Hibernate.HibernateUtil;
import com.tn.beans.Client;


public class ClientDAO extends DAO<Client>  {
	public ClientDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public boolean create(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(client);
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

	@Override
	public boolean update(int id, String data) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Client client = find(id);
			client.setName(data);
			session.update(client);
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

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Client client = (Client) session.get(Client.class, id);
			if (client != null) {
				session.delete(client);
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

	@Override
	public Client find(int id) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Client client = null;
		try {
			tx = session.beginTransaction();
			client = (Client) session.get(Client.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return client;
	}
}
