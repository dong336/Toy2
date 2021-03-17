package com.study.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int getNewArticleNoFromFreeBoard() {
		return sqlSession.selectOne("free_board.selectNewArticleNo", null);
	}
}
