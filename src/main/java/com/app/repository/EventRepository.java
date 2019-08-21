package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> 
{

	@Query("select ename from Event order by ename")
	public List<String> GetEventsName();
	
	@Query("select eid from Event where ename=:ename")
	public int GetEventIdByName(@Param("ename") String ename);
	
}
