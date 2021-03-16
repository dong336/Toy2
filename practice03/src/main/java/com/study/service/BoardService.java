package com.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dao.CommonDAO;

@Service
public class BoardService {
	@Autowired
	CommonDAO commonDAO;
	
	@Transactional
	public List<Map<String, Object>> getAllFreeBoardArticleList(){
		List<Map<String, Object>> articleList = commonDAO.selectList("free_board.selectAllArticleList", null);
			
		return articleList;
	}
	
	@Transactional
	public Map<String, Object> getFreeBoardArticle(Map<String, Object> map){
		Map<String, Object> article = commonDAO.selectOne("free_board.selectArticle", map);
		System.out.println("** success dao");
		
		return article;
	}
}
