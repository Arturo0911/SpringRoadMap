package com.example.service.demo;

import com.example.service.repo.IEmployee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner{


	private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	/*@Autowired
    private IEmployee employee;*/
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		LOG.info("Holis");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue= "Arturon") String name){

		/*Employee empleado = new  Employee("0918237421", "Arturo Francesco", "Negreiros Samanez",
		 "0963951028", "anegreiross@outlook.com","IT", "payload","LikeAStone0101",  "negreiros001");

		CrudRepository<Employee, Integer> employee;
		employee.save(empleado);*/
        return "greeting";

	}

	@GetMapping("/api")
	public int position(@RequestParam(defaultValue = "25") Integer position){
		return position ;
	}


	@GetMapping("/testing_app")
	public String testingApp(@RequestParam(value = "credential", defaultValue = "0000000000") String credential){
		return credential;
	}

	@GetMapping("/greeting")
	public int getGretting(){
		return 28;
	}

}
