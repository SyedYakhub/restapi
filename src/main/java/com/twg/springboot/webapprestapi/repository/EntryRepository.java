package com.twg.springboot.webapprestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springboot.webapprestapi.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> 
{
    public List<Entry> findByUserid(long id);
}
