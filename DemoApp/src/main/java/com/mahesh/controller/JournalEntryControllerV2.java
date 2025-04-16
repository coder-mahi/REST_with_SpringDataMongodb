package com.mahesh.controller;

import java.util.List;
import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mahesh.entity.JournalEntry;
import com.mahesh.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
	
	@Autowired
	private JournalEntryService journalEntryService;
	
	@GetMapping
	public List<JournalEntry> getAll(){
		return journalEntryService.getAll();
	}
	
	@PostMapping
	public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
		journalEntryService.saveEntry(myEntry);
		return myEntry;
	}
	
	@GetMapping("/id/{myId}")
	public JournalEntry getJournalById(@PathVariable ObjectId myId) {
		return journalEntryService.findById(myId).orElse(null);

	}
	
	@DeleteMapping("/id/{myId}")
	public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
		journalEntryService.deleteById(myId);
		return true;

	}
	
	@PutMapping("/id/{myId}")
	public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
	    JournalEntry old = journalEntryService.findById(myId).orElse(null);
	    if (old != null) {
	        old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
	        old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
	        journalEntryService.saveEntry(old);
	        return old;
	    } else {
	        return null; // Or throw a 404 exception
	    }
	}

	
	
}
