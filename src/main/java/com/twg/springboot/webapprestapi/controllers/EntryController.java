package com.twg.springboot.webapprestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twg.springboot.webapprestapi.entities.Entry;
import com.twg.springboot.webapprestapi.services.EntryService;

@RestController
@RequestMapping("/entries")
public class EntryController 
{
    @Autowired
	private EntryService entryService;
    
    
    @PostMapping("/")    //[http://localhost:8080/webapprestapi/entries/]
    public Entry saveEntry(@RequestBody Entry entry)
    {
    	return entryService.saveEntry(entry);
    }
    
    
    @PutMapping("/{id}")    //[http://localhost:8080/webapprestapi/entries/{id}] 
    public Entry updateEntry1(@PathVariable("id") long id, @RequestBody Entry entry)
    {
    	entry.setId(id);
    	
    	return entryService.updateEntry(entry);
    }
    
    
    @PatchMapping("/{id}")    //[http://localhost:8080/webapprestapi/entries/{id}]
    public Entry updateEntry2(@PathVariable("id") long id, @RequestBody Entry entry)
    {
    	Entry entry1=entryService.findById(id);
    	
    	if(entry.getDescription()!=null && entry.getDescription().length()>0)
    	{
    		entry1.setDescription(entry.getDescription());
    	}
    	
    	if(entry.getEntrydate()!=null)
    	{
    		entry1.setEntrydate(entry.getEntrydate());
    	}
    	
    	if(entry.getUserid()>0)
    	{
    		entry1.setUserid(entry.getUserid());
    	}
    	
    	return entryService.updateEntry(entry1);
    }
    
    
    @DeleteMapping("/{id}")    //[http://localhost:8080/webapprestapi/entries/{id}]
    public void deleteEntry(@PathVariable("id") long id)
    {
    	entryService.deleteEntry(id);
    }
    
    
    @GetMapping("/id/{id}")    //[http://localhost:8080/webapprestapi/entries/id/{id}]
    public Entry findById(@PathVariable("id") long id)
    {
    	return entryService.findById(id);
    }
    
    
    @GetMapping("/userid/{userid}")    //[http://localhost:8080/webapprestapi/entries/userid/{userid}]
    public List<Entry> findByUserid(@PathVariable("userid") long userid)
    {
    	return entryService.findByUserid(userid);
    }
    
    
    @GetMapping("/")    //[http://localhost:8080/webapprestapi/entries/]
    public List<Entry> findAll()
    {
    	return entryService.findAll();
    }
}
