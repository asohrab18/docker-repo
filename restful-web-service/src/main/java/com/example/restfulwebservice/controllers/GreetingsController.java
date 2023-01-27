package com.example.restfulwebservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulwebservice.Greeting;

@RestController
@RequestMapping("greetings")
public class GreetingsController {

	@GetMapping("hello")
	public String greet() {
		return "Hello World of Spring Boot!";
		
	}
	
	@GetMapping("hello-bean")
	public Greeting greetByBean() {
		return new Greeting("Hello World of Spring Boot!");
	}
	
	@GetMapping("hello-bean/{name}")
	public Greeting greetByBean(@PathVariable("name")String username) {
		return new Greeting("Welcome, "+username+" to the world of Spring Boot!");
	}
}
