package com.study.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Component
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String joinDate;
	
}
