package com.hibernate.starter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.hibernate.starter.common.AbstractDAO;
import com.hibernate.starter.entity.City;

public class CityDAO extends AbstractDAO<City> {

	public CityDAO() {
		super(City.class);
	}

	public City findCityByName(String name) {
		EntityManager em = getEmf().createEntityManager();

		try {
			List<City> cities = em.createQuery("SELECT c FROM City c WHERE c.name=:name", City.class)
					.setParameter("name", name).getResultList();
			if (cities == null || cities.size() == 0)
				throw new NoResultException("No city found matching the name provided");
			else
				return cities.get(0);
		} finally {
			em.close();
		}
	}

}
