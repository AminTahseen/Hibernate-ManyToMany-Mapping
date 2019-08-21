package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Event;
import com.app.repository.EventRepository;

@Service
public class EventServicesImpl implements EventService {

	@Autowired
	EventRepository Repository;
	
	@Transactional
	@Override
	public void SaveEvent(Event event) 
	{
		Repository.save(event);
	}

	@Transactional
	@Override
	public List<Event> GetAllEvents() 
	{
		List<Event> list_events=Repository.findAll();
		return list_events;
	}

	@Transactional
	@Override
	public Event GetEventById(int id) 
	{
		Event event =Repository.findById(id).get();
		return event;
	}

	@Transactional
	@Override
	public void DeleteEvent(Event event) 
	{
		Repository.delete(event);
	}

	@Transactional
	@Override
	public List<String> GetEventNames() 
	{
		List<String> Event_Names=Repository.GetEventsName(); 
		return Event_Names;
	}

	@Transactional
	@Override
	public int GetEventIdByName(String ename) 
	{
		int eid=Repository.GetEventIdByName(ename);
		return eid;
	}


}
