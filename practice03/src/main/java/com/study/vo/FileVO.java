package com.study.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class FileVO {
	private String fileName;
	private Date modifyDate;
	private String type;
	private String fileSize;
}
