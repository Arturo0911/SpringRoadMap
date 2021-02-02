package com.example.service.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.demo.model.Product;

public interface IProduct extends JpaRepository<Product, Integer> {

}
