package com.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberVO> selectAllMemberList(){
		List<MemberVO> list = sqlSession.selectList("member.selectAllMemberList");
		
		return list;
	}
}
