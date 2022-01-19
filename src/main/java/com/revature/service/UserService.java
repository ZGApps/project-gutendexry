package com.revature.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.GutendexryDriver;
import com.revature.data.BookRepository;
import com.revature.data.UserRepository;
import com.revature.exception.UserNotFoundException;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.model.Book;
import com.revature.model.User;
import java.util.Optional;

@Service 
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class); 
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Transactional(readOnly=true)
	public User getUserByUsername(String username) {
		Optional<User> possibleUser = userRepo.findByUsername(username);
		
		try {
			if(!possibleUser.isPresent()) {
				throw new UserNotFoundException("Username Already Exists.");
			}
		} catch(UserNotFoundException e)
		{
			log.warn("Exception: " + e.getMessage());
		}
			
		
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
	
	// begins a new transaction everytime
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		User returnedUser = userRepo.save(u);
		if(returnedUser.getId() > 0) {
			log.info("Successfully returned User with id {}", returnedUser.getId());
		} else {
			log.warn("Could not add user with username {}", u.getUsername());
		}
		return returnedUser;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User addBook(User u, Book b) {
		if(u.getBooks() != null) {
			u.getBooks().forEach(a -> bookRepo.save(a));
		}
		
		return userRepo.save(u);
	}
}


// in class for this i need specifically:
// Optional<User> findByUsername(String username); 
//vishal added this: