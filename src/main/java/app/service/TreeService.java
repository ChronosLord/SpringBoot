package app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.controller.NodoTree;

@Service
public class TreeService {
	
	public ResponseEntity<?> treeServ( Integer child, Integer deep){
		NodoTree root = new NodoTree(child,deep);
		if(Math.random()>0.5) {
			//throw new RuntimeException("Error de max");
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(root);
	}
}
