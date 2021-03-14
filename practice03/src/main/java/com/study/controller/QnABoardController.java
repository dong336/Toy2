package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("QnABoard")
public class QnABoardController {
	@GetMapping("")
	public String getQnABoard() {
		return "board/QnABoard";
	}
}
