package com.revature;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.data.UserRepository;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.model.User;
import com.revature.service.UserService;

@SpringBootTest
class GutendexryDriverTests{
private UserService userv;
	
private UserRepository mockRepo;

private User dummyUser;

@Before
public void setup() {
	userv = new UserService();
	mockRepo = mock(UserRepository.class); 
	dummyUser = new User("john", "hopkins", "jhop", "pass");
}

@After
public void teardown() {
	
	userv = null;
	dummyUser = null;
	mockRepo = null;	
}

//@Test
//public User testAddUser_ReturnUser() {
//	dummyUser = new User("john", "hopkins", "jhop", "pass");
//	User returnedUser = mockRepo.save(dummyUser);
//	
//	 Mockito.doReturn(fakePk).when(mockRepo).save(dummyUser);
//	
//	if (returnedUser.getId().equals(dummyUser.id)) {
//		
//	}
//	
//	
//}

@Test
public void testIfUsernameExists_throwsException() {
	Assertions.assertThrows(UsernameAlreadyExistsException.class, new Executable() {

        @Override
        public void execute() throws Throwable {

        	String fakeUsername = "username";
        	boolean usernameExists = false;
        	when(mockRepo.existsByUsername(fakeUsername)).thenReturn(true);
        	
        	//this should throw exception
        	usernameExists = userv.isUsernameExists(fakeUsername);

        }
    });
	
	
}

@Test
public User testIfAddUser_returnsnewPkAsId() {
	dummyUser = new User("john", "hopkins", "jhop", "pass");
	Random r = new Random();
	int fakePk = r.nextInt(100);
	
	 Mockito.doReturn(fakePk).when(mockRepo).save(dummyUser);
	 
	 User returnedUser = userv.add(dummyUser);
	 
	// assertEquals(returnUser.getId(), fakePk);w
	 
	 if (returnedUser.getId() == fakePk) {
			return returnedUser;
		}
	 else {
		 return null;
	 }
}

@Test
public void testifDeleteUser_removesUser() {
	
	dummyUser = new User(1, "john", "hopkins", "jhop", "pass", null, null);
	User dummyUser2 = dummyUser; 
	mockRepo.deleteById(dummyUser.getId());
	
	/*
	 * wasn't sure if once dummyUser gets deleted if it shows as null. So i made dummyUser2 object point 
	 * to dummyUser so that once deleted dummyUser2 will be null
	 */
	assertNull(dummyUser2);
}






}
