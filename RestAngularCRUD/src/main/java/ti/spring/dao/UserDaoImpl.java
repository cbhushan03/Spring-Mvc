package ti.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ti.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User findById(long id) {
		 Session session= this.sessionFactory.openSession();
		 Transaction txn = session.beginTransaction();
		 User user = (User) session.get(User.class, new Long(id));
	     if(user.getId() == id){
	         return user;
	     }
	     return null;
	}

	public User findByName(String name) {
		return null;
	}

	public void saveUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
		logger.info("User saved successfully, User Details="+user.getName());
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		logger.info("User updated successfully, User Details="+user.getName());
	}

	public void deleteUserById(long id) {
		Session session= this.sessionFactory.openSession();
		 Transaction txn = session.beginTransaction();
		 User user = (User) session.get(User.class, new Long(id));
	     if(user!=null){
	         session.delete(user);
	     }
	     txn.commit();
	     logger.info("User deleted successfully, User Details="+user.getName());
	}

	public List<User> findAllUsers() {
		Session session = this.sessionFactory.openSession();
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}

	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
