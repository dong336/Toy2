package com.study.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.service.BoardService;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("")
	public String getFreeBoard() {
		return "board/freeBoard";
	}
	
	@ResponseBody
	@GetMapping("getBoardList")
	public List<Map<String, Object>> getBoardList(Model model){
		System.out.println("** FreeBoardController.getBoardList");
		List<Map<String, Object>> list = boardService.getAllArticleList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		return list;
	}
}
