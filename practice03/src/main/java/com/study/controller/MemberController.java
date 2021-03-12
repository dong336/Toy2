package com.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.service.MemberService;
import com.study.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberVO memberVO;
	
	@GetMapping("form")
	public String getMemberForm() {
		log.info("==memberForm==");
		return "member/memberForm";
	}
	
	@PostMapping("addMember")
	public String addMember(@ModelAttribute MemberVO member, HttpServletRequest request, HttpServletResponse response) {
		log.info("==addMember==");
		log.info(member.toString());
		
		memberService.addMember(member);
		memberVO = memberService.login(member);
		
		if(memberVO == null) {
			log.info("** login fail");
			return "/member/addMember";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("member", memberVO);
	    session.setAttribute("isLogOn", true);
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
		
	    log.info("** 세션 속성을 입력 : member(" + memberVO + "), isLogOn (" + true + ")");
	    log.info("** addMember and login success");
	    
	    if(action!= null) {
	    	return "redirect:/" + action;
	    }
	    else {
	        return "redirect:/";	
	    }
	}
}