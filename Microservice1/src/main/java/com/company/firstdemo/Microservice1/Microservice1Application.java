package com.company.firstdemo.Microservice1;

import com.company.firstdemo.Microservice1.daos.ToDoDao;
import com.company.firstdemo.Microservice1.daos.UserDao;
import com.company.firstdemo.Microservice1.entities.ToDo;
import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.EncryptionUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Log
@SpringBootApplication
public class Microservice1Application {

	@Autowired
	ToDoDao toDoDao;

	@Autowired
	UserDao userDao;

	@Autowired
	EncryptionUtils encryptionUtils;

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}



	/*public void run(String... args) throws Exception {
		//
		log.info("hello");
		String encryptedPassword;
		encryptedPassword = encryptionUtils.encrypt("MyRealPassword");
		userDao.save(new User("anegreiros@outlook.com", "Arturo Negreiros", encryptedPassword));
		encryptedPassword = encryptionUtils.encrypt("MyUbuntu");
		userDao.save(new User("negreirosarturo@gmail.com", "Francesco Samanez", encryptedPassword));
		encryptedPassword = encryptionUtils.encrypt("ParrotOs");
		userDao.save(new User("payload_1609@protonmail.com", "Arturon Negreiros", encryptedPassword));
		toDoDao.save(new ToDo(1,"Learning Spring", new Date(), "HIGH", "anegreiross@outlook.com"));
		toDoDao.save(new ToDo(2,"Learning Java", new Date(), "LOW", "negreirosarturo@gmail.com"));
		toDoDao.save(new ToDo(3, "Using this Os to security", new Date(), "HIGH", "payload_1609@protonmail.com"));
		log.info("Data was saved into database");
	}*/

}
