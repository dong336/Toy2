package com.study.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.service.MemberService;
import com.study.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	MemberVO memberVO;
	@Autowired
	MemberService memberService;
	
	@PostMapping("")
	private String login(@RequestParam Map<String, Object> map, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("==RecieveForm==");
		log.info(map.toString());
		
		memberVO = memberService.login(map);

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
		    
		    log.info("** 세션 속성을 입력 : member(" + map.toString() + "), isLogOn (" + true + ")");
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
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		log.info("** logout");
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		log.info("** 세션 속성 삭제 완료");
		
		return "redirect:/";
	}
	
	@GetMapping("form")
	public String getLoginPage() {
		System.out.println("==loginForm==");
		return "navbar/loginForm";
	}

}
