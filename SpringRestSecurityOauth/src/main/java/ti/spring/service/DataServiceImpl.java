package ti.spring.service;

import java.util.ArrayList;
import java.util.List;

import ti.spring.model.User;

public class DataServiceImpl implements DataService {

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();  
	    
		  userList.add(new User(1, "user_a", "user_a@example.com", "9898989898"));  
		  userList.add(new User(2, "user_b", "user_b@example.com", "9767989898"));  
		  userList.add(new User(3, "user_c", "user_c@example.com", "9898459898"));  
		    
		  return userList; 
	}

}
