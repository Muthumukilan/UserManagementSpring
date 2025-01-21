package com.example.User_management_System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderId")
    @SequenceGenerator(name = "OrderId", initialValue = 20000, allocationSize = 1)
	private Long Id;
	private String type;
    private String subType;
    private String product;
    
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
}
