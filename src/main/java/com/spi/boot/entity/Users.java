package com.spi.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users" , schema = "spring")
public class Users {

	@Id
	private int id;

	private String name;

	private String location;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id", referencedColumnName = "id")
	private Food food_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public Food getfood() {
		return food_id;
	}

	public void setfood(Food food_id) {
		this.food_id = food_id;
	}

	public Users(int id, String name, String location, Food food_id) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.food_id =food_id;
	}

	public Users(String name, String location, Food food_id) {
		this.name = name;
		this.location = location;
		this.food_id = food_id;
	}

	public Users() {
	}

	@Override
	public String toString() {
		return "Users{" + "id=" + id + ", name='" + name + '\'' + ", location='" + location + '\'' + ", food='" + food_id
				+ '\'' + '}';
	}
}
