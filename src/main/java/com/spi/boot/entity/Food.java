package com.spi.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foods" , schema = "spring")
public class Food {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String taste;
	
	@Column
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Food(int id, String name, String taste, int quantity) {
		this.id = id;
		this.name = name;
		this.taste = taste;
		this.quantity = quantity;
	}

	public Food() {	
	}
	
	

}
