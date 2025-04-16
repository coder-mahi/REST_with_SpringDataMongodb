package com.mahesh.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mahesh.entity.JournalEntry;
import com.mahesh.repository.JournalEntryRepository;

@Service
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository journalEntryRepository;
	
	public void saveEntry(JournalEntry journalEntry) {
		journalEntryRepository.save(journalEntry);
	}
	
	public List<JournalEntry> getAll(){
		return journalEntryRepository.findAll();
	}
	
	public Optional<JournalEntry> findById(ObjectId id){
		return journalEntryRepository.findById(id);
	}
	
	public void deleteById(ObjectId id) {
		journalEntryRepository.deleteById(id);
	}
}
