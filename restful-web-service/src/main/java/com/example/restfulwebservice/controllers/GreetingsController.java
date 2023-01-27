package com.example.restfulwebservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetings")
public class GreetingsController {

	@GetMapping("hello")
	public String greet() {
		return "Hello World!";
		
	}
}
