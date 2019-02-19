package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Upper {
	
	public Map<String, Object> upp(String hello){
		String helloUpper = hello.toUpperCase();
		Map<String, Object> map = new HashMap<>();
		
		map.put("original", hello);
		map.put("upperCased", helloUpper);
		return map;
	}
}
