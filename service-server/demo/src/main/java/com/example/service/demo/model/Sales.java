package com.example.service.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {
	
	@Id
	private int idSales;
	
	@Column(name = "ProductName",length = 50)
	private String productName;
	
	@Column(name = "DateSales", length = 50)
	private String dateSales;
	
	/**
	 * Getters and Setters
	 * */
	public int getIdSales() {
		return idSales;
	}

	public String getProductName() {
		return productName;
	}

	public String getDateSales() {
		return dateSales;
	}

	public void setIdSales(int idSales) {
		this.idSales = idSales;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setDateSales(String dateSales) {
		this.dateSales = dateSales;
	}

	
	
	
}
