package com.example.restfulwebservice;

public class Greeting {

	private String message;

	public Greeting() {
	}

	public Greeting(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
