package com.twg.springboot.webapprestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twg.springboot.webapprestapi.entities.User;
import com.twg.springboot.webapprestapi.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
    @Autowired
	private UserService userService;
    
	
    @PostMapping("/")  //[http://localhost:8080/webapprestapi/users/]
    public User saveUser(@RequestBody User user)
    {	
    	return userService.saveUser(user);
    }
    
    
    @PutMapping("/{id}")  //[http://localhost:8080/webapprestapi/users/{id}]
    public User updateUser(@PathVariable("id") long id, @RequestBody User user)
    {
    	user.setId(id);
    	
    	return userService.updateUser(user);
    }
    
    
    @DeleteMapping("/{id}")   //[http://localhost:8080/webapprestapi/users/{id}]
    public void deleteUser(@PathVariable("id") long id)
    {    
         userService.deleteUser(id);
    }
    
    
    @GetMapping("/id/{id}")   //[http://localhost:8080/webapprestapi/users/id/{id}]
    public User findById(@PathVariable("id") long id)
    {
    	return userService.findById(id);
    }
    
    
    @GetMapping("/username/{username}")   //[http://localhost:8080/webapprestapi/users/username/{username}]
    public User findByUsername(@PathVariable("username") String username)
    {
    	return userService.findByUsername(username);
    }
    
    
    @GetMapping("/")   //[http://localhost:8080/webapprestapi/users/]
    public List<User> findAll()
    {
    	return userService.findAll();
    }
   
}
