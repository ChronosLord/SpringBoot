package app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.controller.RoutingConstants;

@RestController
public class MinInteger {
	
	@PostMapping(path = RoutingConstants.WS_MIN_INTEGER)
	public ResponseEntity<?> MinInteger(@RequestBody List<Integer> list){
		
		Integer min = 10000000;
		for ( Integer map:list) {
		
			if(map < min) {
				min = map;
			}
		}
		Map<String, Integer> mapi = new HashMap<>();
		mapi.put("minVal",min);
		return ResponseEntity.ok(mapi);
	}
	
	
}
