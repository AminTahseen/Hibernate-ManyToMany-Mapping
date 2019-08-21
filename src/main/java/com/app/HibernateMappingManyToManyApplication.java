package com.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.model.Event;
import com.app.model.Person;
import com.app.repository.EventRepository;
import com.app.repository.PersonRepository;

@SpringBootApplication
public class HibernateMappingManyToManyApplication {

	@Autowired
	PersonRepository repo_person;
	
	@Autowired
	EventRepository repo_event;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingManyToManyApplication.class, args);
	}
	
    public void saveEvent() 
    {
        Set<Person> person_list = new HashSet<Person>(); 

    	Event e1=new Event("WEB TECH-2 CLASSES", person_list);
    	Person p1=new Person("Yasir");
    	Person p2=new Person("Mubeen");
    	Person p3=new Person("Ahmed");

        person_list.add(p1);
        person_list.add(p2);
        person_list.add(p3);
        
        repo_event.save(e1);
    }
    public void savePerson() 
    {
        Set<Event> event_list = new HashSet<Event>();

    	Person p1=new Person("Ahmed", event_list);
    	Person p2=new Person("Mubeen",event_list);
    	Person p3=new Person("Yasir",event_list);

    	
    	Event e1=new Event("Web Tech-1 Classes");
    	Event e2=new Event("Web Tech-2 Classes");
    	
        
        event_list.add(e1);
        event_list.add(e2);
        
        repo_person.save(p1);
        repo_person.save(p2);
        repo_person.save(p3);
 
    }
	

}
