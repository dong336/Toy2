package com.study.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.study.service.FileService;
import com.study.vo.FileVO;

@Controller
@RequestMapping("drive")
public class DriveController {
	
	@RequestMapping("getFileDownload")
    public ModelAndView getFileDownload(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("==getFileDown==");
		
		String path = "c:" + File.separator + "NAS" + File.separator + map.get("fileName");
        System.out.println(map.get("fileName"));
		File downloadFile = new File(path);
        Map<String, File> data = new HashMap<>();
        
        data.put("model", downloadFile);  // 실제 서버에 저장된 파일정보
        
        return new ModelAndView("downloadView", "downloadFile", data);
    }
	
	@ResponseBody
    @PostMapping("dndUpload")
    public List<FileVO> getFileList(Model model, MultipartHttpServletRequest req, HttpServletResponse res) {
		System.out.println("==dndUpload==");
		List<MultipartFile> files = req.getFiles("files");
        List<String> result = new ArrayList<String>();
        List<FileVO> list = new ArrayList<>();
        
        for(int i = 0; i < files.size(); i++) {
        	MultipartFile mpf = files.get(i);
        	result.add(mpf.getOriginalFilename());
        	System.out.println(mpf.getOriginalFilename());
        	String sPath = "";
        	FileVO vo = new FileVO();
        	try {
        		sPath = "c:" + File.separator + "NAS" + File.separator;
        		
        		File chkDir = new File(sPath);

//        		System.out.println("==mpf info==");
//        		System.out.println(mpf.getName());
//        		System.out.println(mpf.getOriginalFilename());
//        		System.out.println(mpf.getSize());
        		
        		if(!chkDir.isDirectory()) {
                    chkDir.mkdirs();
                }
                
        		String filename = sPath + mpf.getOriginalFilename();
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filename));
                
                File file = new File(filename);
//                System.out.println("==dest info==");
//                System.out.println(file.getName());
//                System.out.println(file.canRead());
//                System.out.println(file.length());
                
                vo.setFileName(mpf.getOriginalFilename());
                
                if(file.isFile()) {
                	vo.setType("File");
                	
                	DecimalFormat df = new DecimalFormat("###,###");
                	if(file.length() > 1000000) {
                		System.err.println("**Error : Upload size 1MB exceed!");
                		return null;
                	}	
            		
                	String capacity = df.format(file.length()) + "B";
            		vo.setCapacity(capacity);
                }
                else {
                	// TODO : folder upload
                	System.out.println("**Error : Folder can't uploaded");
                	return null;
                }
        	
                Date modifyDate = new Date(file.lastModified());
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		String resultTimeFormat = sdf.format(modifyDate);
        		vo.setModifyDate(resultTimeFormat);
        	}
        	catch(Exception e) {
        		System.err.println("This is folder!");
        		e.printStackTrace();
        	}
        	
        	System.out.println(vo.toString());
        	list.add(vo);
        }
        
        return list;
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

//        		System.out.println("==mpf info==");
//        		System.out.println(mpf.getName());
//        		System.out.println(mpf.getOriginalFilename());
//        		System.out.println(mpf.getSize());
        		
        		if(!chkDir.isDirectory()) {
                    chkDir.mkdirs();
                }
                
        		String filename = sPath + mpf.getOriginalFilename();
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filename));
                
//                File file = new File(filename);
//                System.out.println("==dest info==");
//                System.out.println(file.getName());
//                System.out.println(file.canRead());
//                System.out.println(file.length());
                	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        	map.put("files", result);
        }
        
        return map;
	}
}