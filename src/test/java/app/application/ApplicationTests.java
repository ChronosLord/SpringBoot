package app.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import app.controller.NodoTree;
import app.controller.Upper;
import app.controller.UpperLetter;
import app.service.TreeService;
import app.service.UpperLetterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	TreeService treeService;
	
	@Autowired
	UpperLetterService upperService;
	
	@Autowired
	UpperLetter upperLetter;
	
	@Autowired
	Upper upper;
	
	@Test
	public void contextLoads() {
		/*
		 * ResponseEntity<?> resp = treeService.treeServ(2, 2);
		 * assertTrue("Status is OK?",resp.getStatusCode().equals(HttpStatus.OK));
		 * assertNotNull(resp);
		 */
		Map<String, Object> map = new HashMap<>();
		map.put("original", "hoLa mundo 2019");
		map.put("upperCased", "HOLA MUNDO 2019");
		
		
		assertEquals(map,upper.upp("hoLa mundo 2019"));
		
		ResponseEntity<?> resp = upperService.upper("hoLa mundo 2019");
		assertTrue(resp.getStatusCode().equals(HttpStatus.OK));
		assertEquals(map, resp.getBody());
		
		ResponseEntity<?> resp2 = ResponseEntity.ok(map);
		assertEquals(resp2,upperLetter.helloNewYear());
	}

}

