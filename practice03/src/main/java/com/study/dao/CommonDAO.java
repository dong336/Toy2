package com.study.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public Map<String, Object> selectOne(String statement, Map<String, Object> condition){
		
		return sqlSession.selectOne(statement, condition);
	}
	
	public int selectInt(String statement, Map<String, Object> condition){
		
		return sqlSession.selectOne(statement, condition);
	}
	
	public String selectStr(String statement, Map<String, Object> condition){
		
		return sqlSession.selectOne(statement, condition);
	}
	
	public List<Map<String, Object>> selectList(String statement, Map<String, Object> condition){
		
		return sqlSession.selectList(statement, condition);
	}
	
	public int insert(String statement, Map<String, Object> condition){
		
		return sqlSession.update(statement, condition);
	}
	
	public int delete(String statement, Map<String, Object> condition){
		
		return sqlSession.delete(statement, condition);
	}
}
