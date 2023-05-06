package com.klinnovations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// Loading Empty Page

	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new SignUpForm());

		return "signup";
	}

	// Signup Functionality

	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean status = userService.signUp(form);

		if (status) {
			model.addAttribute("succMsg", "Account Created, Check your Email");

		} else {
			model.addAttribute("errMsg", "Given Email Allready Teken");
		}

		return "SignUp";

	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());

		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {

		
		String status = userService.login(loginForm);
		
		if(status.contains("success")) {
			
			 
			
			return "redirect:/dashBoard";
		}
		
		model.addAttribute("errMsg", status);
		
		return "login";
	}
	
	
	
	
	
	

}