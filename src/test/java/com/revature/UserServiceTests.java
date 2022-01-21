package com.revature;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.data.UserRepository;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserServiceTests {	

	@InjectMocks
	private UserService userService;
		
	@Mock
	private UserRepository userRepo;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetUserById() {
		
		User u = new User();
		u.setId(1);
		u.setUsername("test");
		Optional<User> uTest = Optional.of(u);
		when(userRepo.findByUsername("test")).thenReturn(uTest);
		
		User user = userService.getUserByUsername("test");
		String returned = user.getUsername();
		verify(userRepo).findByUsername("test");
		
		assertEquals("test", returned);
		
	}
	
}
