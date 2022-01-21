package com.revature;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GutendexryDriverTests {

	@Test
	void contextLoads() {
	}
	
	/*
	@InjectMocks
	private UserService userv;
	
	@Mock
	private UserRepository mockRepo;
	
	@Autowired
	private User dummyUser;
	
	private MockMvc mockMvc;
	
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//	@Before
//	public void setup() {
//		
//		userv = new UserService();
//		mockRepo = mock(UserRepository.class); 
//		dummyUser = new User("john", "hopkins", "jhop", "pass");
//	}

	//@Test
	//public User testAddUser_ReturnUser() {
//		dummyUser = new User("john", "hopkins", "jhop", "pass");
//		User returnedUser = mockRepo.save(dummyUser);
	//	
//		 Mockito.doReturn(fakePk).when(mockRepo).save(dummyUser);
	//	
//		if (returnedUser.getId().equals(dummyUser.id)) {
//			
//		}
	//	
	//	
	//}

	@Test
	public void testIfUsernameExists_throwsException() {
		dummyUser = new User("Dummy","User","username1","pass12345");
		dummyUser.setId(1);
		//when(mockRepo.findByUsername("username1")).thenReturn(dummyUser);
		 Mockito.doReturn(dummyUser).when(mockRepo).findByUsername("username1");

		
		User user = userv.getUserByUsername("username1");
		//verify(mockRepo).findByUsername(null)

        assertEquals(dummyUser, user);
       // assertThat(user.getId(), is("username1"));
	}
	*/

}
