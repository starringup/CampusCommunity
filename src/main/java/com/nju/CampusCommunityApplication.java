package com.nju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CampusCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusCommunityApplication.class, args);
	}
	
	@RequestMapping("/home")
	public String home(){
		return "Welcome to campus community !";
	}
}

