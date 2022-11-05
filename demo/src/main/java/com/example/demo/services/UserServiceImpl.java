package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
@Component
public class UserServiceImpl  implements UserService{
	private static List<User> users= new ArrayList<>();
	private static int count=0;
	static {
		
		users.add(new User(count++,"Arda",LocalDate.now().minusYears(23)
				));
		users.add(new User(count++,"John",LocalDate.now().minusYears(29)
				));
		users.add(new User(count++,"Michael",LocalDate.now().minusYears(38)
				));
	}
    @Override
	public List<User> getAllUsers() {
		return users;
	}
    @Override
	public User getUser(int theId) {
		if(theId<users.size()) {
			return users.get(theId);
		
		}
		return null;
		
	}
    @Override
	public User addUser(User theUser) {
		theUser.setId(count++);
		
		users.add(theUser);	
		return theUser;
		// TODO Auto-generated method stub
		
	}
    @Override
	public boolean deleteById(int theId) {
		return users.removeIf(user -> user.getId()==theId);
	}

	

}
