package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.UpperLetterService;

@RestController
public class UpperLetter {

	public UpperLetter() {
		// TODO Auto-generated constructor stub
	}
	private String hello = "hoLa mundo 2019";
	@Autowired
	private UpperLetterService uppServ;
	
	@GetMapping(path = "/hellonewyear")
	public ResponseEntity<?> helloNewYear(){
		//String hello = "hoLa mundo 2019";
		return uppServ.upper(hello);
	}
	
}
