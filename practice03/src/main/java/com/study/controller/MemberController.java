package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.dao.MemberDAO;
import com.study.service.MemberService;
import com.study.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;
	
	@GetMapping("membersList")
	private String getAllMemberList(Model model) {
		List<MemberVO> list = memberService.getAllMemberList();
		
		model.addAttribute("membersList", list);
		
		return "member/membersList";
	}
}
