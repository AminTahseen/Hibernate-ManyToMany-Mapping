package com.app.services;

import java.util.List;

import com.app.model.Person;

public interface PersonService {
	
	void SavePerson(Person person);
	
	List<Person> GetAllPersons();
	
	Person GetPersonById(int id);
	
	void DeletePerson(Person person);
	
	Integer GetPersonIdByName(String pname);
		
	List<Person> FindSearchedPerson(String pname);
}
