package com.study.service;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		String sPath = "C:" + File.separator + "NAS";
		File paths = new File(sPath);	// 경로를 기준으로 파일을 참조
		File files[] = paths.listFiles();	// 경로를 통해 파일명을 문자열 배열로 얻음
					
		for(File file : files) {
			FileVO vo = new FileVO();
			String capacity = getCapacityFormat(file.length());
						
			if(file.isFile()) {
				vo.setCapacity(capacity);
				vo.setType("File");
			}
			if(file.isDirectory()) {
				vo.setCapacity(null);
				vo.setType("Folder");
			}
			
			String modifyDate = getDateFormat(file.lastModified());
			vo.setModifyDate(modifyDate);
			vo.setFileName(file.getName());
			
			list.add(vo);
		}
		
		result.put("dataList", list);
		
		return result;
	}
	
	private String getDateFormat(long dateOfMilisecond) {
		Date modifyDate = new Date(dateOfMilisecond);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String resultTimeFormat = sdf.format(modifyDate);
		
		return resultTimeFormat;
	}
	
	private String getCapacityFormat(long fileSize) {
		
		if(fileSize > 10000000) return "10MB 이상";
		
		DecimalFormat df = new DecimalFormat("###,###");
		String capacity = df.format(fileSize) + "B";
		
		return capacity;
	}
}
