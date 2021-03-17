package com.study.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.service.BoardService;
import com.study.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberVO memberVO;
	
	@PostMapping("submitForm")
	public String submitFormArticle(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getId();
		
		map.put("id", id);
		boardService.addNewArticleToFreeBoard(map);
		
		return "redirect:/freeBoard";
	}
	
	@GetMapping("addArticle")
	public String addArticle(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if(session == null) {
			log.error("잘못된 접근");
			return "redirect:/login/form";
		}
		boolean b = (boolean)session.getAttribute("isLogOn");
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(b != true || member == null) {
			log.error("잘못된 로그인 시도");
			return "redirect:/login/form";
		}
		
		System.out.println("** FreeBoardController.addArticle");
		System.out.println(b);
		System.out.println(member.toString());

		return "board/freeBoardArticleForm";
	}
	
	@RequestMapping("getArticle")
	public String getArticle(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("** param : " + map.toString());
		
		Map<String, Object> article = boardService.getFreeBoardArticle(map);
	
//		System.out.println("** article : " + article.toString());
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
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		return list;
	}
}
