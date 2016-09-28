package com.hibernate.starter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * City Table
 * @author manjunatha_h
 */
@Entity
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = -3980945951045744590L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "known_for")
	private String knownFor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKnownFor() {
		return knownFor;
	}

	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}

}
