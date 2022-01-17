package com.revature.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.LombokApplication;
import com.revature.data.UserRepository;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.model.User;
import java.util.Optional;

@Service 
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(LombokApplication.class); 
	
	@Autowired
	UserRepository userRepo;
	
	@Transactional(readOnly=true)
	public User getUserByUsername(String username) {
		Optional<User> possibleUser = userRepo.findByUsername(username);
		return possibleUser.isPresent() ? possibleUser.get() : null;
	}
	
	@Transactional(readOnly=true)
	public boolean isUsernameExists(String username) {
		boolean usernameExists = false;
		try {
			usernameExists = userRepo.existsByUsername(username);
			if(usernameExists == true)
				throw new UsernameAlreadyExistsException("Username Already Exists.");
		} catch(UsernameAlreadyExistsException e)
		{
			log.warn("Exception: " + e.getMessage());
		}
		
		return usernameExists;
	}
}

// in class for this i need specifically:
// Optional<User> findByUsername(String username); 
//vishal added this:
//	public boolean existsByUsername(String username);
