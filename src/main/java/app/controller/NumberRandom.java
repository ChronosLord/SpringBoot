package app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.controller.RoutingConstants;

@RestController
public class NumberRandom {
	
	@GetMapping(path = RoutingConstants.WS_NUMBER,produces="application/json" )
	public ResponseEntity<?> randomNumber(){
		Map<String, String> map = new HashMap<>();
		
		Double value1= Math.floor(Math.random()*100);
		Integer value2 = value1.intValue();
		String value = value2.toString();
		
		Date date1= new Date(); 		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		String dateRand = df.format(date1);
		map.put("randomNumber", value);
		map.put("generationDate", dateRand);
		
		return ResponseEntity.ok(map);
	}
}
