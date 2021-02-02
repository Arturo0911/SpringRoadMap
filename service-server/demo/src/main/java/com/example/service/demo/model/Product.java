package com.example.service.demo.model;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	private int idProduct;
	private String productName;
	private String productCode;
	private int productQuantity;
	private float productPrice;
	
	
	
	
}
