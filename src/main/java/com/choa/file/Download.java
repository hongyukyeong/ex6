package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView {
	
	//일반 클래스가 아닌 View 역할을 해야함
	
	public Download() {
		setContentType("application/download;charser=URF-8");
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File f = (File)model.get("downloadFile");
		String oriName = (String)model.get("oriName");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		
		//String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		fileName = fileName.substring(fileName.lastIndexOf("_")+1); //fileName을 쓰고 싶으면 바로 밑에 fileName으로 바꿔준다
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fi = null;
		
		fi = new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
		
	}
}
