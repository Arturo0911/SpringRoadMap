package com.company.firstdemo.Microservice1;

import com.company.firstdemo.Microservice1.daos.ToDoDao;
import com.company.firstdemo.Microservice1.daos.UserDao;
import com.company.firstdemo.Microservice1.entities.ToDo;
import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.EncryptionUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Log
@SpringBootApplication
public class Microservice1Application implements CommandLineRunner {

	@Autowired
	ToDoDao toDoDao;

	@Autowired
	UserDao userDao;

	@Autowired
	EncryptionUtils encryptionUtils;

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}


	
}
