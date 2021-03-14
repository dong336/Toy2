package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	@GetMapping("")
	public String getFreeBoard() {
		return "board/freeBoard";
	}
}
