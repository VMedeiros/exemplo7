package br.cesed.si.tap.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.tap.sboot.domain.User;
import br.cesed.si.tap.sboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ResponseEntity< List<User> > listAllUsers() {
		
		return new ResponseEntity< List<User> >
		(userService.listAllUsers(), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String id) {
		
		User user = userService.getById(id);
		
		return user == null ? 
				new ResponseEntity<User>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {

		try {
			userService.save(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/user", method = RequestMethod.DELETE)
	public ResponseEntity< List<User> > deleteAllUsers() {
		
		return new ResponseEntity< List<User> >
		(userService.listAllUsers(), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteById(@PathVariable String id) {
		
		User user = userService.deleteById(id);
		
		return user == null ? 
				new ResponseEntity<User>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<User>(user, HttpStatus.OK);
	}

	public UserService getUserService() {
		return userService;
	}
}
