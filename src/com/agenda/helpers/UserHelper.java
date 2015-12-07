package com.agenda.helpers;

import com.agenda.exceptions.ResourceNotFoundException;
import com.agenda.model.User;

public class UserHelper {

	public static User findByName(String name) {
		User user = new User(name, "");
		
		if(User.users.contains(user)){
			return User.users.get(User.users.indexOf(user));
		}
		
		throw new ResourceNotFoundException(User.class);
	}
}
