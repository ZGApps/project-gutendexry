package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{ 

	
	
	Optional<User> findByUsername(String username); 
	
	public boolean existsByUsername(String username);

}