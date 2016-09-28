package com.hibernate.starter.main;

import com.hibernate.starter.dao.CityDAO;
import com.hibernate.starter.entity.City;

public class BootStrap {

	public static void main(String[] args) {
		CityDAO cityDAO = new CityDAO();
		City city = new City();
		city.setKnownFor("IT");
		city.setName("Bengaluru");
		city = cityDAO.merge(city);

		System.out.println("---------------------Added city to DB successfully------------------------ ");
		System.out.println("Saved entity with ID :" + city.getId());
		// City savedEntity = cityDAO.find(Long.parseLong("1"));
		City savedEntity = cityDAO.findCityByName("Bengaluru");

		System.out.println("---------------------Got entity from DB-------------------------------------");

		System.out.println(savedEntity.getName());
	}

}
