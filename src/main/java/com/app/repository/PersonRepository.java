package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Person;


public interface PersonRepository extends JpaRepository<Person,Integer>
{
	@Query("SELECT pid FROM Person WHERE pname=:name")
	public Integer GetPersonIdByName(@Param("name") String Name);
	

	@Query("SELECT p FROM Person p WHERE p.pname=:name")
	public List<Person> FindSearchedPerson(@Param("name") String pname);

	
}
