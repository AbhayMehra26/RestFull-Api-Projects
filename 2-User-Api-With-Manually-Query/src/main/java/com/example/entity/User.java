package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User 
{
	@Id
	@GeneratedValue(generator ="user_seq" )
	@SequenceGenerator(name="user_seq", initialValue =101 ,allocationSize = 1)
	private int id;
	
	@NotNull(message = "firstname is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String firstname;
	
	@NotNull(message = "lastname is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String lastname ;
	
	@NotNull(message = "adress is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String adress;
	
	
	@NotNull(message = "Date of Birth is required")
	@Pattern(regexp = "^(19|20)\\d\\d-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", 
	         message = "Date of Birth must be in the format yyyy-MM-dd")
	private String dob;
	
	@NotNull(message = "Phone is required")
	@Pattern(regexp = "^[0-9]{10,10}$",message = "Phone number must have 10 digits")
	private String phoneno;
	
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message = "Email is not valid")
	private String email;
	
	@NotNull(message = "Password is required")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
	         message = "Password must be at least 8 characters long, contain an uppercase letter, a digit, and a special character")
	private String password;

	public User(String firstname, String lastname, String adress, String dob, String phoneno, String email,
			String password) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.dob = dob;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", adress=" + adress
				+ ", dob=" + dob + ", phoneno=" + phoneno + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
