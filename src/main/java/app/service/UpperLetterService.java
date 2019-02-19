package app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.controller.Upper;

@Service
public class UpperLetterService {
	
	@Autowired
	Upper upper;
	
	public ResponseEntity<?> upper(String hello){
		
		/*
		 * String helloUpper = hello.toUpperCase(); Map<String, Object> map = new
		 * HashMap<>();
		 * 
		 * map.put("original", hello); map.put("upperCased", helloUpper);
		 */
		return ResponseEntity.ok(upper.upp(hello));
	}
}
