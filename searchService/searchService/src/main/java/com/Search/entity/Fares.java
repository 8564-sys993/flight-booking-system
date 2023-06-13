package com.Search.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fares {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "fare_id")
	private long id;
    
    private String fare;
    private String currency;
	public Fares() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fares(long id, String fare, String currency) {
		super();
		this.id = id;
		this.fare = fare;
		this.currency = currency;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
	}
	
    
    
	

}
