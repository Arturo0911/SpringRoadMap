package com.example.service.demo.controller;

import com.example.service.demo.model.User;
import com.example.service.demo.repo.IUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	@Autowired
	private IUser iUser;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);

		User user = new User();
		user.setId(1);
		user.setNames("Arturo Negreiros");
		iUser.save(user);

		return "greeting";
	}

}
