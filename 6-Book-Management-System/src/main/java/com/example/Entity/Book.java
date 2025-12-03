package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "book") 
 public class Book 
{
	
	
	  @Id
	 @GeneratedValue(generator ="book_seq") 
	@SequenceGenerator(name="book_seq",initialValue = 101 ,allocationSize =1 )

	private int id;
	private String title ; 
	private int price; 
	private String author;
	private String category ;
	public Book(String title, int price, String author, String category) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
