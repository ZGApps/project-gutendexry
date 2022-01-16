package com.revature.model;

public enum Category {
	
	Canada("Canada Category"),
	Children("Children's Category"),
	Christmas("Christmas Category"),
	Classics("Classics Category"),
	Crime("Crime Category"),
	Country("Countries Category"),
	Education("Education Category"),
	Emmy("Emmy's Picks Category"),
	Fiction("Fiction Category"),
	FineArts("FineArts Category"),
	GeneralWorks("General Works Category"),
	Geography("Geography Category"),
	History("History"),
	LanguageAndLiterature("Language and Literature"),
	Law("Law Category"),
	Music("Music Category"),
	PsychologyAndPhilosophy("Psychology and Philosophy Category"),
	Religion("Religion Category"),
	Science("Science Category"),
	SocialSciences("Social Sciences Category"),
	Technology("Technology Category"),
	Wars("Wars Category");
	
	private String category;

	Category(String category){
       this.category= category;
    }

    public String getCategory(){
        return category;	
    }

}

// in User class:

//@ElementCollection(targetClass = Category.class,fetch = FetchType.EAGER)
//@CollectionTable(name = "user_category", joinColumns = @JoinColumn(name = "user_id"))
//@Enumerated(EnumType.STRING)
//@Column(name = "category_name")
//List<Category> interestedCategories;

// explanation:
//@ElementCollection - Defines a collection of instances of a basic type or embeddable class. @CollectionTable - pecifies the table that is used for the mapping of collections of basic or embeddable types (name - name of the collection table, joinColumn - The foreign key columns of the collection table).
//Enumerated - Specifies that a persistent property or field should be persisted as a enumerated type.
