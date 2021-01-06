package com.example.ln.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@RequestMapping("/index")
	public String  index() {
		
		return "index";
	}
	
	@RequestMapping("/fileupload")
	public String upload(@RequestParam("myfile")MultipartFile file,Model model) {
		System.out.println(file.getOriginalFilename());
		
		try {
			//获取文件名
			String fileName = file.getOriginalFilename();
			//获取文件后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			//文件上传的路径
			String filePath = "D:/upload/";
			//重新加工
			fileName = filePath+UUID.randomUUID()+suffixName;
			//文件对象
			File dest = new File(fileName);
			//创建路径
			if(!dest.getParentFile().exists()) {
				
				dest.getParentFile().mkdirs();
				
			}
			//上传文件
			file.transferTo(dest);
			model.addAttribute("info", "上传文件成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "上传文件失败");
		}

		
		return "index";
	}
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response)throws Exception {
		File file = new File("D:\\upload\\62ae0df5-7542-4802-aba2-c8f056fe24c8.rar");
		FileInputStream fis = new FileInputStream(file);
		response.setContentType("application/force-download");
		//设置下载文件的名称
		response.addHeader("Content-disposition", "attachment;filename=jianli.rar");
		
		OutputStream os = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1) {
			os.write(buf, 0, len);
		}
		
		os.close();
		fis.close();
		
	}
	
}
