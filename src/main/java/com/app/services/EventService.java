package com.app.services;

import java.util.List;

import com.app.model.Event;

public interface EventService {
	
	void SaveEvent(Event event);
	
	List<Event> GetAllEvents();
	
	Event GetEventById(int id);
	
	void DeleteEvent(Event event);
	
	List<String> GetEventNames();
	
	int GetEventIdByName(String ename);
	
}
