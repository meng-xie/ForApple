package com.mengxie.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(  	@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {

			String fileFormat=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1,file.getOriginalFilename().length());
			if (!fileFormat.equalsIgnoreCase("txt")) {
				return "file format must is txt!"  ;
			}
				  BufferedReader reader=null;
				  int count =0 ;
				try { 
					
					InputStream in =  file.getInputStream();
					reader = new BufferedReader(new InputStreamReader(in));
			        String line= reader.readLine() ;
			    
			        while (line != null) {
			            String [] tokens = line.split("\\s+");
			            for (int i = 0; i < tokens.length; i++) {
							if(tokens[i].length()==5){
								count++;
							}
						}
			        	
			   		    line = reader.readLine();
			        }
			        reader.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// Closing the resources

						reader.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				return "You successfully uploaded file and occurrences of all words of length 5 is " + count;
			 
		} else {
			return "You failed to upload   because the file was empty.";
		}
	}

	 
}
