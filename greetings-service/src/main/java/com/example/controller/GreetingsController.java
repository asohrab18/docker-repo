package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Greetings;

/**
 * REST APIs:
http://localhost:8000/greetings/hello
http://localhost:8000/greetings/hello-bean
http://localhost:8000/greetings/hello-bean/John
*/
@RestController
@RequestMapping("greetings")
public class GreetingsController {

	@GetMapping("hello")
	public String greet() {
		return "Hello World of Spring Boot!";

	}

	@GetMapping("hello-bean")
	public Greetings greetByBean() {
		return new Greetings("Hello World of Spring Boot!");
	}

	@GetMapping("hello-bean/{name}")
	public Greetings greetByBean(@PathVariable("name") String username) {
		return new Greetings("Hi " + username + "! Welcome to the world of Spring Boot!");
	}
}
