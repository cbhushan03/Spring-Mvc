package com.cbt.tutorials;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cbt.tutorials.model.Person;
@Repository
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(p);
		transaction.commit();
		logger.info("Person updated successfully, Person Details="+p);
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();	
		Transaction transaction = session.beginTransaction();
		Person p = (Person) session.load(Person.class, new Integer(id));
		//transaction.commit();
		logger.info("Person loaded successfully, Person details="+p);
		
		return p;
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		transaction.commit();
		//session.close();
		logger.info("Person deleted successfully, person details="+p);
	}
}
