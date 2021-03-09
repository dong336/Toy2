package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("favicon.ico")
	public String getFavicon() {
		return null;
	}
	
	@GetMapping("/")
	public String getHome() {
		System.out.println("==Home==");
		return "home";
	}
	
	@GetMapping("main")
	public String getMain() {
		return "navbar/main";
	}
	
	@GetMapping("board")
	public String getBoard() {
		return "navbar/boardList";
	}
	
	@GetMapping("drive")
	public String getDrive() {
		System.out.println("==Drive==");
		return "navbar/drive";
	}
	
	@GetMapping("mp")
	public String getMp() {
		return "navbar/mp";
	}
	
	@GetMapping("canvas")
	public String getCanvas() {
		System.out.println("==Canvas==");
		return "navbar/canvas";
	}
}
