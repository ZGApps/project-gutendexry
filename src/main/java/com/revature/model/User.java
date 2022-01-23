package com.revature.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Book.class})

	private int id;
	
	@NonNull
	@Length(min=2)
	private String firstName;
	
	@NonNull
	@Length(min=2)
	private String lastName;
	
	@NonNull
	@Length(min=3)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	
	@NonNull
	@Length(min=5)
	private String password;
	
	
	@ManyToMany
	@JoinTable(name = "users_books",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonView({JsonViewProfiles.User.class})
	private Set<Book> books;
	
	
	
	/*
	 * @ElementCollection(targetClass = Category.class,fetch = FetchType.EAGER)
	 * 
	 * @CollectionTable(name = "user_category", joinColumns = @JoinColumn(name =
	 * "user_id"))
	 * 
	 * @Enumerated(EnumType.STRING)
	 * 
	 * @Column(name = "category_name")
	 * 
	 * @JsonView({JsonViewProfiles.User.class}) private List<Category>
	 * interestedCategories;
	 */
	public User(@NonNull @Length(min=2) String firstName,
			@NonNull @Length(min=2) String lastName,
			@NonNull @Length(min=3)	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NonNull @Length(min=5) String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public User(int id, @NonNull @Length(min=2) String firstName,
			@NonNull @Length(min=2) String lastName,
			@NonNull @Length(min=3)	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NonNull @Length(min=5) String password,@NonNull Book[] books) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.books = new HashSet<>(Arrays.asList(books));
	}
	
	public User removeBook(Book book) {
		Set<Book> books = this.getBooks();
		if(books.contains(book)) {
			books.remove(book);
		}
		this.setBooks(books);
		return this;
	}
	
	public User addBook(Book book) {
		books.add(book);
		return this;
	}
	
}
