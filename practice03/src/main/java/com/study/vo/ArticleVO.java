package com.study.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter
@Setter
public class ArticleVO {
	String title;
	String id;
	String content;
	String writeDate;
}
