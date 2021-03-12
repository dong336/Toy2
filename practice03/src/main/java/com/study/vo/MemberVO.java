package com.study.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String joinDate;
	
}
