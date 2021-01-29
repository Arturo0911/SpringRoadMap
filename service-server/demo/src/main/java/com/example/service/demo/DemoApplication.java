package com.example.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue= "Arturon") String name){
		return String.format("Hello %s", name);
	}

	@GetMapping("/api")
	public int position(@RequestParam(defaultValue = "25") Integer position){
		return position ;
	}


	@GetMapping("/testing_app")
	public String testingApp(@RequestParam(value = "credential", defaultValue = "0000000000") String credential){
		return credential;
	}

}
