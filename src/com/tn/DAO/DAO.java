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

	public abstract boolean Create(T obj);

	public abstract boolean Update(int id, String data);

	public abstract boolean Delete(int id);

	public abstract T Find(int id);

}
