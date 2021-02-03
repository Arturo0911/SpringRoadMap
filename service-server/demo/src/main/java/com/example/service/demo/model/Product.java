package com.example.service.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	
	@Column(name= "product_name", length = 50)
	private String productName;
	
	@Column(name = "product_stock")
	private int productStock;
	
	@Column(name = "product_price")
	private float productPrice;
	
	
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}
	
	public int getProductStock() {
		return productStock;
	}
	public float getProductPrice() {
		return productPrice;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	
	
}
