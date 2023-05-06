package com.klinnovations.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.entity.User;
import com.klinnovations.repo.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public boolean signUp(SignUpForm form) {
		// TODO Auto-generated method stub
		
		User user = UserRepository.findById(form.getEmail());

		if (user != null) {
		
		}
		
		return true;
	}

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		
User entity = UserRepository.findByEmailAndPassword(form.getEmail(), form.getPassword());
		
		if(entity == null) {
			return "Invalid Credentials";
		}
		
		
		return null;
	}

}
