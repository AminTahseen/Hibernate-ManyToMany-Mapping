package com.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_event", joinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"), 
	inverseJoinColumns = @JoinColumn(name = "eid", referencedColumnName = "eid"))
	private Set<Event> events;

	public Person() {
		super();
	}

	public Person(String pname) {
		super();
		this.pname = pname;
	}

	public Person(String pname, Set<Event> events) {
		super();
		this.pname = pname;
		this.events = events;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", events=" + events + "]";
	}
	
	
	
}
