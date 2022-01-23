package com.revature.data;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Book;
import com.revature.model.User;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Set<Book> findByOwnersUsername(String username);
}