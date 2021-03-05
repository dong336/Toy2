package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@GetMapping("form")
	public String getLoginPage() {
		System.out.println("==loginForm==");
		return "navbar/loginForm";
	}
	
	@PostMapping("verify")
	public String verify() {
		// input email and pwd
		// TODO : login info verification
		return null;
	}
}
