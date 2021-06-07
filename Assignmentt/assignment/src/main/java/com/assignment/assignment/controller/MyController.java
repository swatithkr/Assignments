package com.assignment.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.service.IdgeneratorService;

@RestController
public class MyController {
	
	IdgeneratorService idgeneratorService;
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to the page";
	}
	
	public String doIncement() {
		return "Result is:" +Integer.toString(idgeneratorService.increaseNumber());
	}
	
	

}
