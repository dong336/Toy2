package com.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.service.MemberService;
import com.study.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberVO memberVO;
	@Autowired
	MemberService memberService;
	
	@PostMapping("")
	private String login(@ModelAttribute MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("==RecieveForm==");
		log.info(member.toString());
		
		memberVO = memberService.login(member);

		// TODO : 03.10 login validate, admin mode
		if(memberVO != null) {
			// Go to admin mode
			if(memberVO.getId().equals("admin") && memberVO.getPwd().equals("admin")) {
				log.info("** To admin");
				return "admin/home_admin";
			}
		
		    HttpSession session = request.getSession();
		    session.setAttribute("member", memberVO);
		    session.setAttribute("isLogOn", true);
		    String action = (String)session.getAttribute("action");
		    session.removeAttribute("action");
		    
		    log.info("** 세션 속성을 입력 : member객체, isLogOn true");
		    log.info("** login success");
		    
		    if(action!= null) {
		    	return "redirect:/" + action;
		    }
		    else {
		        return "redirect:/";	
		    }
		}
		else {
			
			log.info("** login fail");
			
			rAttr.addAttribute("result","loginFailed");
			return "redirect:/login/form";
		}	
	}
}