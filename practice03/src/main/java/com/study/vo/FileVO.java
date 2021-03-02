package com.study.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class FileVO {
	private String fileName;
	private String type;
	private String modifyDate;
	private String capacity;
}
