package ti.spring.dao;

import java.util.List;

import ti.spring.model.User;

public interface UserDao {
	User findById(int id);
	User findBySSO(String sso);
	
	List<User> findAllUser();
}
