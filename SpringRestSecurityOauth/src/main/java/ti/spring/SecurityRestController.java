package ti.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ti.spring.model.User;
import ti.spring.service.DataService;

@RestController
@RequestMapping("/api/users")
public class SecurityRestController {
	@Autowired
	DataService dataService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>>  listAllUser() {
		List<User> users = dataService.getUserList();
		if(users.size()==0) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		 return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}
