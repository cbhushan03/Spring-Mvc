package ti.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ti.spring.model.User;
import ti.spring.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUser(){
		List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id){
		User user = userService.findById(id);
		if(user==null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
		User curntUser = userService.findById(id);
		if(curntUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		curntUser.setAge(user.getAge());
		curntUser.setName(user.getName());
		curntUser.setSalary(user.getSalary());
		
		userService.updateUser(curntUser);
		
		return new ResponseEntity<User>(curntUser,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user,UriComponentsBuilder builder){
		if(userService.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userService.saveUser(user);
		
		HttpHeaders header = new HttpHeaders();
		header.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
	
}
