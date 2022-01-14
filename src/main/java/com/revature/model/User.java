package com.revature.model;

import java.lang.annotation.Repeatable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Book.class, JsonViewProfiles.Category.class})

	private int id;
	
	
	@Length(min=2)
	private String firstName;
	private String lastName;
	
	@NotBlank
	@Length(min=3)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	
	@NotBlank
	@Length(min=5)
	private String password;
	
	
	@ManyToMany
	@JoinTable(name = "users_books",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonView(JsonViewProfiles.User.class)
	private Set<Book> books;
	
	@ManyToMany
	@JoinTable(name = "users_categories",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonView(JsonViewProfiles.User.class)
	private Set<Category> categories;

	
	// need to fix imports so I can create constructor with restraints
	
	
	
}
