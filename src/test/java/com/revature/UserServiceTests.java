package com.revature;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.revature.data.BookRepository;
import com.revature.data.UserRepository;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.model.Book;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserServiceTests {	

	@InjectMocks
	private UserService userService;
		
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private BookRepository bookRepo;
	
	

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetUserByUsername() {
		
		User u = new User();
		u.setUsername("test");
		Optional<User> uTest = Optional.of(u);
		when(userRepo.findByUsername("test")).thenReturn(uTest);
		
		User user = userService.getUserByUsername("test");
		String returned = user.getUsername();
		verify(userRepo).findByUsername("test");
		
		assertEquals("test", returned);


	
}
	@Test
	public void testIfUserNameAlreadyExists_returnTrue() {
	
	
        	
        	User u = new User();
    		u.setUsername("test");
    		when(userRepo.existsByUsername("test")).thenReturn(true);
    		boolean exists = false;
    	exists 	= userService.isUsernameExists("test");
    		Assert.assertTrue(exists);

        }
	@Test
	public void testAddUser() {
		User u = new User();
		u.setUsername("test");
		u.setId(1);
		when(userRepo.save(u)).thenReturn(u);
		User returnedUser = userService.add(u);
		
		Assert.assertEquals(returnedUser, u);
	}
	@Test
	public void testRemoveUser() {
		User u = new User();
		u.setId(1);
		u.setUsername("test");
		Optional<User> uTest = Optional.of(u);
	//	when(userService.getUserByUsername("test")).thenReturn(u);
		when(userRepo.findByUsername("test")).thenReturn(uTest);
		
		User u2 = userService.remove("test");
		Assert.assertEquals(1, u2.getId());
	}
	

	@Test
	public void testAddBook() {
		User u = new User();
		Book b = new Book();
		Book b1 = new Book();
		when(bookRepo.save(b)).thenReturn(b);
		b1 = bookRepo.save(b);
		
		Assert.assertEquals(b, b1);
		
		
		
	}
	
	}
	

