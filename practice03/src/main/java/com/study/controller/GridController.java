package com.study.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.FileService;

@RestController
@RequestMapping("grid")
public class GridController {
	@Autowired
	FileService fileService;
	
	@GetMapping("data")
	public Map<String, Object> getData(Model model) throws Exception{
		Map<String, Object> map = fileService.fileVOMap(); 
		
		return map;
	}
}
