package com.infy.Day10Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.infy.Day10Assignment.beans")
public class Day10AssignmentApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(Day10AssignmentApplication.class, args);

	}

}
