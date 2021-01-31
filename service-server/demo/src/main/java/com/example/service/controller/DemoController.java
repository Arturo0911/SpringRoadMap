package com.example.service.controller;

import com.example.service.model.Employee;
import com.example.service.repo.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private IEmployee employeeRepo;

    @GetMapping("/initdb")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //logica 
		
		Employee empleado = new  Employee("0918237421", "Arturo Francesco", "Negreiros Samanez",
		 "0963951028", "anegreiross@outlook.com","IT", "payload","LikeAStone0101",  "negreiros001");

        employeeRepo.save(empleado);
        model.addAttribute("name", name);
        return "greeting";
    }
    
}
