package com.twg.springboot.webapprestapi.services;

import java.util.List;

import com.twg.springboot.webapprestapi.entities.User;

public interface UserService 
{
  public User saveUser(User user);
  public User updateUser(User user);
  public void deleteUser(long id);
  public User findById(long id);
  public List<User> findAll();
  public User findByUsername(String username);
}
