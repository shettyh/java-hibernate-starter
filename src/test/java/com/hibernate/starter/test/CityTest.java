package com.hibernate.starter.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hibernate.starter.dao.CityDAO;
import com.hibernate.starter.entity.City;

/**
 * Unit tests for City table
 * 
 * @author manjunatha_h
 */
public class CityTest {

	private CityDAO _CityDAO = new CityDAO();

	@Test(enabled = true)
	public void testInsert() {
		City city = new City();
		city.setName("Mysore");
		city.setKnownFor("Dasara");
		_CityDAO.merge(city);
	}

	@Test(enabled = true, dependsOnMethods = "testInsert")
	public void testRetrieve() {
		City savedCity = _CityDAO.findCityByName("Mysore");
		Assert.assertEquals("Mysore", savedCity.getName());
	}

}
