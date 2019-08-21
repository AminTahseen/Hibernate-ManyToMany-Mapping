package com.app.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Event;
import com.app.model.Person;
import com.app.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository repository;
	
	@Transactional
	@Override
	public void SavePerson(Person person) 
	{
		repository.save(person);
	}

	@Transactional
	@Override
	public List<Person> GetAllPersons() 
	{
		List<Person> person_list=repository.findAll();
		return person_list;
	}

	@Transactional
	@Override
	public Person GetPersonById(int id) 
	{
		Person person=repository.findById(id).get();
		if(person==null) 
		{
			return null;
		}
		else 
		{		
			return person;
		}
	}
	
	@Transactional
	@Override
	public void DeletePerson(Person person) 
	{
		repository.delete(person);
	}

	@Transactional
	@Override
	public Integer GetPersonIdByName(String pname) 
	{
		Integer pid=repository.GetPersonIdByName(pname);
		if(pid==null) 
		{
			return null;
		}
		else
		{
			return pid;
		}
	}
	
	@Transactional
	@Override
	public List<Person> FindSearchedPerson(String pname) 
	{
		List<Person> person_list=repository.FindSearchedPerson(pname);
		return person_list;
	}
	

}
