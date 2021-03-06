package com.example.service.demo.res;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.demo.model.Product;
import com.example.service.demo.repo.IProduct;

@RestController
@RequestMapping("/product")
public class RestProductController {
	
	
	@Autowired
	private IProduct iProduct;
	
	@GetMapping("/list_product")
	public List<Product> getListProduct(){
		return iProduct.findAll();
	}
	
	@PostMapping("/insertion")
	public void insertProduct(@RequestBody Product product) {
		iProduct.save(product);
	}
	
	@PutMapping("/updating")
	public void updateProduct(@RequestBody Product product) {
		
		Product productUpdate = new Product();
		productUpdate.setIdProduct(product.getIdProduct());
		productUpdate.setProductName(product.getProductName());
		productUpdate.setProductStock(product.getProductStock());
		productUpdate.setProductPrice(product.getProductPrice());
		
		iProduct.save(productUpdate);

	}
	
	@DeleteMapping("/popproduct/{productId}")
	public void deleteProduct(@PathVariable Integer productId) {
		iProduct.deleteById(productId);
	}
	
	
	
	
	
	
	
	
}
