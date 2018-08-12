package com.cbt.tutorials.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.cbt.tutorials.PersonDAO;
import com.cbt.tutorials.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO ;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Transactional
	public void save(Person p) {
		// TODO Auto-generated method stub
		this.personDAO.save(p);
	}

	@Transactional
	public List<Person> list() {
		// TODO Auto-generated method stub
		return this.personDAO.list();
	}

	@Transactional
	public void update(Person p) {
		// TODO Auto-generated method stub
		this.personDAO.update(p);
	}

	@Transactional(readOnly=true)
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return this.personDAO.getPersonById(id);
	}

	@Transactional
	public void remove(int id) {
		// TODO Auto-generated method stub
		this.personDAO.remove(id);
	}
	
	
	
	
}
