package com.elena.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elena.model.AppUser;
import com.elena.security.TokenUtils;
import com.elena.service.AppUserService;

@RestController
@RequestMapping(value="/me")
public class MeController {
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AppUserService appUserService;
	
	
	 @RequestMapping(method = RequestMethod.GET)
	  public ResponseEntity<AppUser> authenticatedUser() {
		 
		 String token = request.getHeader("X-Auth-Token");
		 String username = tokenUtils.getUsernameFromToken(token);
		 AppUser authenticatedUser = new AppUser();
		 authenticatedUser = appUserService.loadUserByUsername(username);
		 
		 return new ResponseEntity<AppUser>(authenticatedUser, new HttpHeaders(), HttpStatus.OK);
		  
	  }

}
