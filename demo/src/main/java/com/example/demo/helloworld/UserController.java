package com.example.demo.helloworld;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
		
	}
	@GetMapping("/user/{id}")
	public EntityModel<User>getUser(@PathVariable("id") int theId) {
		User user=userService.getUser(theId);
		if(user==null) {
			throw new UserNotFoundException();
		}
		EntityModel<User> entityModel= EntityModel.of(user);
		Link link =linkTo(methodOn(this.getClass()).getUsers()).withRel("all users");
		entityModel.add(link);
		return entityModel;
		
	}
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User theUser) {
		 User savedUser=userService.addUser(theUser);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).build();
		
	}
	@DeleteMapping("user/{id}")
	public void deleteById(@PathVariable("id") int theId) {
		 boolean b= userService.deleteById(theId);
		 if(b==false) {
			 throw new UserNotFoundException();
		 }
		
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFound() {
		return "User not found";
		
	}
	
	

}
