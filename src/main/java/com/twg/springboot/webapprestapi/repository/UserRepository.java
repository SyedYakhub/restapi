package com.twg.springboot.webapprestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springboot.webapprestapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    public User findByUsername(String username);
}
