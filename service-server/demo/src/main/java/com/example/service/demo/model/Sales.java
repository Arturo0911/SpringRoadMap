package com.example.service.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Sales")
public class Sales {
    
    @Id
    private int idSales;

    @ManyToMany
    Set<Product> likeProducts;


    @Column(name= "product_name", length = 50)
    private String productName;

    @Column(name= "product_description", length = 200)
    private String description;

    @Column(name = "date_sales")
    private String dateSales;


    @Column(name = "quantity_sold")
    private int quantitySold;
}
