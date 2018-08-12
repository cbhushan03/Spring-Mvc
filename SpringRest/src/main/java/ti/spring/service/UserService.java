package ti.spring.service;

import java.util.List;

import ti.spring.model.User;

public interface UserService {
	User findById(int id);
	User findBySSO(String sso);
	
	List<User> findAllUser();
}
