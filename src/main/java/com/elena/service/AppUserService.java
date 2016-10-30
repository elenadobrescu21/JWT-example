package com.elena.service;

import java.io.Serializable;

import com.elena.model.AppUser;

public interface AppUserService {
	
	 AppUser loadUserByUsername(String username);

	 Serializable post(AppUser appUser);

	 AppUser get(long id);

	 AppUser patch(AppUser appUser);

	 boolean delete(long id);

}
