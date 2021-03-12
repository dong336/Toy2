package com.study.service;

import java.util.List;
import java.util.Map;

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
	@Autowired
	private MemberVO memberVO;
	
	public List<Map<String, Object>> getAllMemberList() throws DataAccessException{
		List<Map<String, Object>> memberList = memberDAO.selectList("member.selectAllMemberList", null);
		
		return memberList;
	}
	
	public MemberVO login(Map<String, Object> map) throws DataAccessException{
		Map<String, Object> member = memberDAO.selectOne("member.loginById", map);
		System.out.println(member.toString());
		
		String id = (String)member.get("ID");
		String pwd = (String)member.get("PWD");
		
		System.out.println(id);
		System.out.println(pwd);
		
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		System.out.println(memberVO.toString());
		
		return memberVO;
	}
	
	public int addMember(Map<String, Object> param) throws DataAccessException{
		
		
		return memberDAO.insert("insertMember", param);
	}
}
