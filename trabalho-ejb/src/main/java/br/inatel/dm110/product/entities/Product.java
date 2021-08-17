package br.inatel.dm110.product.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT", schema = "public")
public class Product implements Serializable {
	private static final long serialVersionUID = -3226154108429480413L;
	
	@Id
	private int code;
	private String name;
	private String description;
	private float price;
	private String category;
	
	public Product() {}	
	
	public Product(int code, String name, String description, float price, String category) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}	
}
