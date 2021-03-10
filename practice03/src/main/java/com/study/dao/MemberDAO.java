package com.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.study.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberVO> selectAllMemberList() throws DataAccessException{
		List<MemberVO> list = sqlSession.selectList("member.selectAllMemberList");
		
		return list;
	}
	
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException{
		MemberVO vo = sqlSession.selectOne("member.loginById", memberVO);
		
		return vo;
	}
}
