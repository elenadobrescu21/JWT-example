package com.elena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elena.model.AppUser;
import com.elena.service.AppUserService;

@RestController
@RequestMapping("/")
public class HomeController {
	
	 @Autowired
	 AppUserService appUserService;
	 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> home() {
		AppUser appUser = appUserService.get(1);
        return ResponseEntity.ok(appUser);
	}

}
