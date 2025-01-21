package com.example.User_management_System.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CMPS {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderId")
    @SequenceGenerator(name = "OrderId", initialValue = 20000, allocationSize = 1)
    private Long orderId;  // Primary Key
    
    private String type;
    private String subType;
    private String product;
	private String status;
	
    public Products getProducts() {
		return Products;
	}
	public void setProducts(Products products) {
		Products = products;
	}
	@ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products Products;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserLogin userLogin; 

    
    public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    
    public UserLogin getUserLogin() {
        return userLogin;
    }
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
