package com.cbt.tutorials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cbt.tutorials.model.Person;

@Service
public interface PersonService {
	public void save(Person p);
	public void update(Person p);
	public Person getPersonById(int id);
	public void remove(int id);
	public List<Person> list();
	
}
