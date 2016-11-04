package com.elena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elena.model.AppUser;
import com.elena.service.AppUserService;
import com.elena.service.AppUserServiceImpl;

@RestController
@RequestMapping("/auth")
public class RegisterController {
	
	@Autowired
	AppUserService appUserService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertUser(@RequestBody AppUser user) {
		String authorities = "ROLE_ADMIN, ROLE_EM PLOYEE, ROLE_MANAGER";
		boolean userNameExistent = false;
		if(appUserService.loadUserByUsername(user.getUsername()) != null) {
			return new ResponseEntity<String>("Username already exists", new HttpHeaders(), HttpStatus.IM_USED);
			
		} else {
		String userPassword = user.getPassword();
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passEncoder.encode(userPassword);
		appUserService.post(new AppUser(user.getUsername(), encodedPassword, authorities));
		return new ResponseEntity<String>("User has been created", new HttpHeaders(), HttpStatus.OK);
		}
		
	}
	
	

}
