package com.cbt.tutorials;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cbt.tutorials.model.Person;
@Component
public interface PersonDAO {
	public void save(Person p);
	public void update(Person p);
	public Person getPersonById(int id);
	public void remove(int id);
	public List<Person> list();
	
	
}
