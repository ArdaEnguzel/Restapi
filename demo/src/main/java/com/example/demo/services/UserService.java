package com.example.demo.services;

import java.util.List;


import com.example.demo.entities.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(int theId);
	public User addUser(User theUser);
	public boolean deleteById(int theId);
	

}
