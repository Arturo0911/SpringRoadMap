package com.example.service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class DemoApplication{
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
