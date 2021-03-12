package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dao.MemberDAO;
import com.study.vo.MemberVO;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberVO> getAllMemberList() throws DataAccessException{
		List<MemberVO> memberList = memberDAO.selectAllMemberList();
		
		return memberList;
	}
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		return memberDAO.loginById(memberVO);
	}
	
	public int addMember(MemberVO memberVO) throws DataAccessException{
		return memberDAO.insertMember(memberVO);
	}
}
