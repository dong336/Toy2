package com.study.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.service.BoardService;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("getArticle")
	public String getArticle(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("** param : " + map.toString());
		
		Map<String, Object> article = boardService.getFreeBoardArticle(map);
	
		System.out.println("** article : " + article.toString());
		request.setAttribute("article", article);
		
		return "board/freeArticle";
	}
	
	@GetMapping("")
	public String getFreeBoard() {
		return "board/freeBoard";
	}
	
	@ResponseBody
	@GetMapping("getBoardList")
	public List<Map<String, Object>> getBoardList(Model model){
		System.out.println("** FreeBoardController.getBoardList");
		List<Map<String, Object>> list = boardService.getAllFreeBoardArticleList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		return list;
	}
}
