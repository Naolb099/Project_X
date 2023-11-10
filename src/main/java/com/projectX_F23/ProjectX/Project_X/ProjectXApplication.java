package com.projectX_F23.ProjectX.Project_X;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjectXApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectXApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot() {
		return "This is a homepage test";
	}

	@GetMapping("/another")
	public String apiRoot1() {
		return "This is another page";
	}

	@GetMapping("/yetanother")
	public String apiRoot2() {
		return "Yet another page";
	}
}