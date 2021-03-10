package com.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("login")
public class LoginController {
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		log.info("** logout");
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		log.info("** 세션 속성 삭제 완료");
		
		return "redirect:/";
	}
	
	@GetMapping("form")
	public String getLoginPage() {
		System.out.println("==loginForm==");
		return "navbar/loginForm";
	}

}
