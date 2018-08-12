package ti.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ti.spring.dao.UserDao;
import ti.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return userDao.findBySSO(sso);
	}
	
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}

}
