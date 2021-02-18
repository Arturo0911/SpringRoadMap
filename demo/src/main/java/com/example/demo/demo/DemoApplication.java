package com.example.demo.demo;

import com.example.demo.demo.daos.UserDao;
import com.example.demo.demo.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserDao userDao) throws Exception{

		return (String[] args) ->{
			User user1 = new User("Arturo", "anegreiros@outlook.com");
			User user2 = new User("Francesco", "negreirosarturo@gmail.com");
			userDao.save(user1);
			userDao.save(user2);
			userDao.findAll().forEach(System.out::println);

		};


	}

}
