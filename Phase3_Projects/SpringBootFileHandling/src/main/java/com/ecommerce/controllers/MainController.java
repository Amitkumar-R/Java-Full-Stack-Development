package com.ecommerce.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.http.HttpHeaders;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileToUpload(@RequestParam("file") MultipartFile file) {
		String result = "File was uploaded successfully";
		
		try {
			File convertFile = new File("/var/tmp/" + file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convertFile);
			fos.write(file.getBytes());
			fos.close();
		} catch(Exception e) {
			result = "Error" + e.getMessage();
		} finally {
			return result;
		}
	}
	
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
		String fileName = "static/demo.txt";
		ClassLoader cl = new MainController().getClass().getClassLoader();
		
		File file = new File(cl.getResource(fileName).getFile());
		
		InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("Content-disposition", String.format("attachment;filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cahce");
		headers.add("Expires", "O");
		
		ResponseEntity<Object> responseEntity = 
				ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(isr);
		return responseEntity;
	}
 
}
