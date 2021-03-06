package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name="books_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(exclude = {"owners"}) @ToString(exclude= {"owners"}) // This is important to prevent Hibernate loop -> https://stackoverflow.com/questions/53540056/what-causes-spring-boot-fail-safe-cleanup-collections-to-occur
public class Book {

	@Id
	@Column(name = "book_id")
	@JsonView({ JsonViewProfiles.User.class, JsonViewProfiles.Book.class })
	private int id;

	@ManyToMany(mappedBy="books")
	@JsonView({JsonViewProfiles.Book.class})
	private Set<User> owners;
	
	public Book(int id) {
		super();
		this.id = id;
	}

}
