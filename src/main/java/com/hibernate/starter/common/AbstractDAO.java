package com.hibernate.starter.common;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Top level class for all entity DAO's
 * @author manjunatha_h
 * @param <T> DB Entity class
 */
public class AbstractDAO<T> {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
	private Class<? extends Serializable> entity;

	protected AbstractDAO(Class<? extends Serializable> entity) {
		this.entity = entity;
	}

	protected EntityManagerFactory getEmf() {
		return emf;
	}

	public T merge(T object) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			return em.merge(object);
		} finally {
			em.getTransaction().commit();
			em.close();
		}
	}

	public T find(Object id) {
		EntityManager em = emf.createEntityManager();
		try {
			return (T) em.find(entity, id);
		} finally {
			em.close();
		}
	}

}
