package com.tn.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class DAO<T> {

	protected SessionFactory sessionFactory = null;
	protected Transaction tx = null;
	protected Session session = null;

	public DAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public abstract boolean create(T obj);

	public abstract boolean update(int id, String data);

	public abstract boolean delete(int id);

	public abstract T find(int id);

}
