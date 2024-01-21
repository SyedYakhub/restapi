package com.twg.springboot.webapprestapi.services;

import java.util.List;

import com.twg.springboot.webapprestapi.entities.Entry;

public interface EntryService 
{
	public Entry saveEntry(Entry entry);
    public Entry updateEntry(Entry entry);
    public void deleteEntry(long id);
    public Entry findById(long id);
    public List<Entry> findAll();
    public List<Entry> findByUserid(long userid);
}
