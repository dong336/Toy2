package com.study.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class LayoutController {
	@RequestMapping("")
	public String getLayout() {
		return "main.tiles";
	}
}
