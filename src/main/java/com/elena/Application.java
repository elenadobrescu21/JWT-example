package com.elena;

import static org.junit.Assert.assertSame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.elena.model.AppUser;
import com.elena.service.AppUserService;
import com.elena.service.AppUserServiceImpl;

@SpringBootApplication

public class Application {
	
	 @Autowired
	 private static AppUserService appUserService;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);	
	}

}
