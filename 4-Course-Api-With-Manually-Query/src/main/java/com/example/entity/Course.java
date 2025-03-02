package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course 
{
	@Id
	@GeneratedValue(generator = "coure_seq")
	@SequenceGenerator(name = "coure_seq" , allocationSize = 1,initialValue = 101 )
	private int cid;
	
	private String cname ;
	private String cduration;
	private int cprice;
	
	
	public Course() {
		super();
	}
	public Course( String cname, String cduration, int cprice) {
		super();
		
		this.cname = cname;
		this.cduration = cduration;
		this.cprice = cprice;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCduration() {
		return cduration;
	}
	public void setCduration(String cduration) {
		this.cduration = cduration;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}

