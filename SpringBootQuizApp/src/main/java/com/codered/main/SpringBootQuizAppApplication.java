package com.codered.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootQuizAppApplication {

	public static void main(String[] args) 
	{
		System.out.println("start..");
		SpringApplication.run(SpringBootQuizAppApplication.class, args);
		
		System.out.println("end.");
	}

}
