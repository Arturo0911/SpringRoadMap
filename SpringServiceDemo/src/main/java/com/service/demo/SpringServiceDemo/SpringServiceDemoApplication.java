package com.service.demo.SpringServiceDemo;

import com.service.demo.SpringServiceDemo.daos.ToDoDao;
import com.service.demo.SpringServiceDemo.daos.UserDao;
import com.service.demo.SpringServiceDemo.entities.ToDo;
import com.service.demo.SpringServiceDemo.entities.User;
import com.service.demo.SpringServiceDemo.utilities.EncryptionUtils;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Log
@SpringBootApplication
public class SpringServiceDemoApplication implements CommandLineRunner {

	//private static final Logger log = LoggerFactory.getLogger(SpringServiceDemoApplication.class);

	@Autowired
	UserDao userDao;

	@Autowired
	ToDoDao toDoDao;

	@Autowired
	EncryptionUtils encryptionUtils;

	public static void main(String[] args) {

		SpringApplication.run(SpringServiceDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
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



	}
}
