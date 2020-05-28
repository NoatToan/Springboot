package com.laptrinhjavaweb.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.laptrinhjavaweb.constant.SystemConstant;


@Component
@MultipartConfig
public class UploadFileUtil {

	public int uploadFile(CommonsMultipartFile file,HttpServletRequest session,String myPath) throws IOException {
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(myPath);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	    return 1;
	}

}
