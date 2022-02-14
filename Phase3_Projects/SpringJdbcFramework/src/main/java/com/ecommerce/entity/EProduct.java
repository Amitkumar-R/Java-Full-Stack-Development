package com.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EProduct {

	private long ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	
	public long getID() { return ID; }
	public String getName() { return name; }
	public BigDecimal getPrice() { return price; }
	public Date getDateAdded() { return dateAdded; }
	
	public void setID(long iD) { ID = iD; }
	public void setName(String name) { this.name = name; }
	public void setPrice(BigDecimal price) { this.price = price; }
	public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }	
	
}
