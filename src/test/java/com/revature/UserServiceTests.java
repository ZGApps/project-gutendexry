package com.revature;


public class UserServiceTests {
	
	//@InjectMocks
	//private UserController uCont;
	
	/*@InjectMocks
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
				
	
		
//		
//		
//		Assertions.assertThrows(UsernameAlreadyExistsException.class, new Executable() {
//
//	        @Override
//	        public void execute() throws Throwable {
//
//	        	String fakeUsername = "username";
//	        	boolean usernameExists = false;
//	        	when(mockRepo.existsByUsername(fakeUsername)).thenReturn(true);
//	        	
//	        	//this should throw exception
//	        	usernameExists = userv.isUsernameExists(fakeUsername);
//
//	        }
//	    });
//		
		
	}
//
//	@Test
//	public User testIfAddUser_returnsnewPkAsId() {
//		dummyUser = new User("john", "hopkins", "jhop", "pass");
//		Random r = new Random();
//		int fakePk = r.nextInt(100);
//		
//		 
//		 User returnedUser = userv.add(dummyUser);
//		 
//		// assertEquals(returnUser.getId(), fakePk);w
//		 
//		 if (returnedUser.getId() == fakePk) {
//				return returnedUser;
//			}
//		 else {
//			 return null;
//		 }
//	}
//
//	@Test
//	public void testifDeleteUser_removesUser() {
//		
//		dummyUser = new User(1, "john", "hopkins", "jhop", "pass", null, null);
//		User dummyUser2 = dummyUser; 
//		mockRepo.deleteById(dummyUser.getId());
//		
//		/*
//		 * wasn't sure if once dummyUser gets deleted if it shows as null. So i made dummyUser2 object point 
//		 * to dummyUser so that once deleted dummyUser2 will be null
//		 */
//		assertNull(dummyUser2);
//	}*/






	}
