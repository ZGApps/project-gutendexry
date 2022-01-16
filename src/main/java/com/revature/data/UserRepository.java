package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{ 

	
	
	Optional<User> findByUsername(String username); 
	
	public List<User> findByOrderByLastName(); 
	
	public List<User> findByOrderByBook();
	
	public List<User> findByOrderByCategory();
	
	// TODO: modify this so that it returns either boolean or PK of the user deleted. 
	public void deleteById(int id);
	
	
	@Query("FROM User WHERE book LIKE %:pattern")
	public List<User> findByBookContains(String pattern);
	
	@Query("FROM User WHERE category LIKE %:pattern")
	public List<User> findByCategoryContains(String pattern); 
	
	// TODO add customer queries findByBookOrderByLastName
}