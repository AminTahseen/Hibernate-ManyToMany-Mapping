package com.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Event
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String ename;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "events")
    private Set<Person> persons;

	public Event() {
		super();
	}

	public Event(String ename)
	{
		super();
		this.ename = ename;
	}

	public Event(String ename, Set<Person> persons) {
		super();
		this.ename = ename;
		this.persons = persons;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return ename;
	}

	
	
}
