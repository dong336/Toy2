package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.dao.MemberDAO;
import com.study.service.MemberService;
import com.study.vo.MemberVO;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;
	
	@ResponseBody
	@PostMapping("allMembersList")
	private List<MemberVO> getAllMemberList() throws Exception{
		System.out.println("==Ajax==");
		List<MemberVO> list = memberService.getAllMemberList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		return list;
	}
}
