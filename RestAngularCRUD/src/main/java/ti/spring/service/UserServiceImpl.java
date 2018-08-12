package ti.spring.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ti.spring.dao.UserDao;
import ti.spring.model.User;
@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

    @Transactional
	public List<User> findAllUsers() {
        return this.userDao.findAllUsers();
    }
     
    @Transactional(readOnly=true)
    public User findById(long id) {
        return this.userDao.findById(id);
    }
     
    public User findByName(String name) {
        return null;
    }
     
    @Transactional
    public void saveUser(User user) {
        this.userDao.saveUser(user);
    }
    
    @Transactional
    public void updateUser(User user) {
    	this.userDao.updateUser(user);
    }
 
    @Transactional
    public void deleteUserById(long id) {
         this.userDao.deleteUserById(id);
    }
 
    public boolean isUserExist(User user) {
        return false;
    }
 
    public void deleteAllUsers() {
   
    }

}
