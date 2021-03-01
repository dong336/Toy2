package com.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.study.vo.FileVO;

@Service
public class FileService {
	public Map<String, Object> fileVOMap() throws Exception{
		Map<String, Object> result = new HashMap<>();
		List<FileVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 20; i++) {
			FileVO vo = new FileVO();
			
			
			
			list.add(vo);
		}
		
		result.put("dataList", list);
		
		return result;
	}
}
