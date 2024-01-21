package com.twg.springboot.webapprestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.webapprestapi.entities.Entry;
import com.twg.springboot.webapprestapi.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService 
{
    
	@Autowired
	private EntryRepository entryRepository;

	@Override
	public Entry saveEntry(Entry entry) {

		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {

		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(long id) {

		entryRepository.deleteById(id);
	}

	@Override
	public Entry findById(long id) {

		return entryRepository.findById(id).get();
	}

	@Override
	public List<Entry> findAll() {

		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findByUserid(long userid) {

		return entryRepository.findByUserid(userid);
	}

}
