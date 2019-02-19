package app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.repository.numbersRepository;
@Service
public class NumberService {
	
	//@GetMapping(name="/generateRandomInteger")
	public ResponseEntity<?> generateRandomInteger(){
		//String random = "randomNumber: 10,";
		Map<String, String> map = new HashMap<String, String>();
		map.put("randomNumber", "10");
		map.put("generationDate","01-01-2019");
		
		return ResponseEntity.ok(map);
	}
}
