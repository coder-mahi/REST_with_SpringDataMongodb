package com.mahesh.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private User user;
	
	Map<Long, User> userEntries = new HashMap<>();
	
	@GetMapping
	public List<User> getAll(){
		return new ArrayList<>(userEntries.values());
	}
	
	@GetMapping("/id/{myid}")
	public ResponseEntity<?> findById(@PathVariable long myid) {
		if(userEntries.containsKey(myid)) {
			return new ResponseEntity<User>(userEntries.get(myid),HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User newUser) {
		try {
			userEntries.put(newUser.getId(), newUser);
			return new ResponseEntity<>(newUser,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/id/{myid}")
	public ResponseEntity<?> findUserEntity(@PathVariable long myid){
		try {
			userEntries.remove(myid);
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/id/{myid}")
	public ResponseEntity<?> updateUserEntity(@PathVariable long myid,@RequestBody User newUser){
		try{
			userEntries.replace(myid, newUser);
			return new ResponseEntity<User>(newUser,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
