package com.mahesh.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.entity.User;
import com.mahesh.repository.UserEntryRepository;

@Service
public class UserEntryService {
	@Autowired
	private UserEntryRepository userEntryRepository;
	
	public void saveEntry(User user) {
		userEntryRepository.save(user);
	}
	
	public List<User> getAll(){
		return userEntryRepository.findAll();
	}
	
	public Optional<User> findById(ObjectId id){
		return userEntryRepository.findById(id);
	}
	
	public void deleteById(ObjectId id) {
		userEntryRepository.deleteById(id);
	}
}
