package com.study.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("drive")
public class DriveController {
	@RequestMapping("getFileDownload")
    public ModelAndView getFileDownload(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("==getFileDown==");
		
		String path = "c:" + File.separator + "NAS" + File.separator + map.get("filename");
        File downloadFile = new File(path);
        Map<String, File> data = new HashMap<>();
        
        data.put("model", downloadFile);  // 실제 서버에 저장된 파일정보
        
        return new ModelAndView("downloadView", "downloadFile", data);
    }
	
	@ResponseBody
    @PostMapping("upload")
    public Map<String, List<String>> upload(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		System.out.println("==Upload==");
		List<MultipartFile> files = req.getFiles("files");
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < files.size(); i++) {
        	MultipartFile mpf = files.get(i);
        	result.add(mpf.getOriginalFilename());
        	String sPath = "";
        	
        	try {
        		sPath = "c:" + File.separator + "NAS" + File.separator;
        		
        		File chkDir = new File(sPath);
                if(!chkDir.isDirectory()) {
                    chkDir.mkdirs();
                }
                
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(sPath + mpf.getOriginalFilename()));

        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        	map.put("files", result);
        }
        
        return map;
	}
}
