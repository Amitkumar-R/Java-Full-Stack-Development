package com.bean;

import java.math.BigDecimal;
import java.util.Date;

public class EProductBean {
	
	private long id;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	
	public EProductBean() {
		
	}

	public EProductBean(long id, String name, BigDecimal price, Date dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
}
