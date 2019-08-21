package com.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Event;
import com.app.model.Person;
import com.app.services.EventService;
import com.app.services.PersonService;

@Controller
public class ApplicationController {
	
	private static final Logger LOGGER = Logger.getLogger("ApplicationController");

	@Autowired
	PersonService person_services;
	
	@Autowired
	EventService event_services;
	
	@RequestMapping("/")
	private String index(Model map) 
	{
		try 
		{
			List<Person>persons_list=person_services.GetAllPersons();
			map.addAttribute("list", persons_list);
		}
		catch (Exception e) 
		{
		
		}
		return "index";
	}
	
	@RequestMapping("/createEventPage")
	private String EventPage() 
	{
		return "eventPage";
	}
	
	@RequestMapping("/SaveEvent")
	private String SaveEvent(@RequestParam("ename") String ename,Model map) 
	{
		try 
		{
			Event event=new Event(ename);
			LOGGER.log(Level.INFO,"Saving....");
			event_services.SaveEvent(event);
			LOGGER.log(Level.SEVERE,"Saved");
		}
		catch (Exception e)
		{
			 LOGGER.log(Level.SEVERE,e.getMessage().toString());
		}
		
		List<Person>persons_list=person_services.GetAllPersons();
		map.addAttribute("list", persons_list);
		return "index";
	}
	
	@RequestMapping("/createPersonPage")
	private String PersonPage(Model map) 
	{
		try 
		{
			List<String> event_names=event_services.GetEventNames();
			map.addAttribute("ename", event_names);
		}
		catch (Exception e) 
		{
			
		}
		return "personPage";
	}
	
	@RequestMapping("/SavePersonEvent")
	private String SavePersonEvent(
			                       @RequestParam("pname") String pname,
			                       @RequestParam("ename") String ename,
			                       Model map
			                       ) 
	{
		try 
		{
			Person p;
	  		if(person_services.GetPersonIdByName(pname)==null) 
	  		{
	  		    Set<Event> event_list = new HashSet<Event>();
	  			Event event=event_services.GetEventById(event_services.GetEventIdByName(ename));
	  			event_list.add(event);
	  			p=new Person(pname, event_list);
	  			person_services.SavePerson(p);
	  		}
	  		else 
	  		{
	  			p=person_services.GetPersonById(person_services.GetPersonIdByName(pname));
	  			Set<Event> event_list = p.getEvents();
	  			Event event=event_services.GetEventById(event_services.GetEventIdByName(ename));
	  			event_list.add(event);
	  			p.setEvents(event_list);
	  			person_services.SavePerson(p);
	  		}
	  		
	  		List<Person>persons_list=person_services.GetAllPersons();  		
	  		map.addAttribute("list", persons_list);
		}
		catch (Exception e) 
		{
			 LOGGER.log(Level.SEVERE,e.getMessage().toString());
		}
  		return "index";
	}
	
	@RequestMapping("/PersonEventPage")
	private String PersonEventPage() 
	{
		return "deletePersonEvents";
	}
	
	@RequestMapping("/EventList")
	private String PersonEventPageDelete(Model map,@RequestParam("pname") String pname) 
	{
		List<Person>persons_list=person_services.FindSearchedPerson(pname);  		
  		map.addAttribute("list", persons_list);	
  		
		return "deletePersonEvents";
	}
	
	@RequestMapping("/DeletePersonEvent")
	private String DeletePersonEvent(
			@RequestParam("pname") String pname,
			@RequestParam("ename") String ename,
			Model map
			                        ) 
	{
		try 
		{
			Person p=person_services.GetPersonById(person_services.GetPersonIdByName(pname));
			Set<Event> plist=p.getEvents();
			Event e=event_services.GetEventById(event_services.GetEventIdByName(ename));
			plist.remove(e);
			p.setEvents(plist);
			person_services.SavePerson(p);
		}
		catch (Exception e) 
		{
			 LOGGER.log(Level.SEVERE,e.getMessage().toString());
		}
		List<Person>persons_list=person_services.FindSearchedPerson(pname);  		
  		map.addAttribute("list", persons_list);	
  		
		return "deletePersonEvents";
	}
}
