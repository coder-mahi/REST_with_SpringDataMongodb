package com.mahesh.controller;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
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
import com.mahesh.service.UserEntryService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserEntryService userEntryService;
	
//	private Map<ObjectId, User> userEntries = new HashMap<>();
	
	@GetMapping
	public List<User> getAll(){
//		return new ArrayList<>(userEntries.values());
		
		return userEntryService.getAll();
	}
	
	@GetMapping("/id/{myid}")
	public ResponseEntity<?> findUserById(@PathVariable ObjectId myid) {
		Optional<User> userEntry = userEntryService.findById(myid);
		if(userEntry.isPresent()) {
			return new ResponseEntity<>(userEntry.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User newUser) {
//		try {
//			userEntries.put(newUser.getId(), newUser);
//			return new ResponseEntity<User>(newUser,HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
//		}
		
		try {
			userEntryService.saveEntry(newUser);
			return new ResponseEntity<>(newUser,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(newUser,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/id/{myid}")
	public ResponseEntity<?> findUserEntity(@PathVariable ObjectId myid){
		try {
//			userEntries.remove(myid);
			userEntryService.deleteById(myid);
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@PutMapping("/id/{myid}")
	public ResponseEntity<?> updateUserEntity(@PathVariable ObjectId myid, @RequestBody User newUser) {
	    User old = userEntryService.findById(myid).orElse(null);
	    if (old != null) {
	        old.setId(newUser.getId() != null ? newUser.getId() : old.getId());
	        old.setName(newUser.getName() != null && !newUser.getName().equals("") ? newUser.getName() : old.getName());
	        old.setEmail(newUser.getEmail() != null && !newUser.getEmail().equals("") ? newUser.getEmail() : old.getEmail());

	        userEntryService.saveEntry(old);
	        return new ResponseEntity<>(old, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
}
