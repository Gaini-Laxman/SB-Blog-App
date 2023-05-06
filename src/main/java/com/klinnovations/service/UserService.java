package com.klinnovations.service;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;

public interface UserService {
	
	public boolean signUp(SignUpForm form);
	
	public String login(LoginForm form);
	
}