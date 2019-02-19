package app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.controller.NodoTree;
import app.service.TreeService;

@RestController
public class TreeRandom {
	
	private List<NodoTree> children = new ArrayList<NodoTree>() ;
	private Double value;
	private Integer NumChildrens;
	private Integer Deep;
	
	@Autowired
	private TreeService serv;
	
	public TreeRandom() {
		/*
		 * List<NodoTree> children2 = new ArrayList<NodoTree>() ; Double val; val =
		 * Math.floor(Math.random()*10)/10;
		 * 
		 * for (int i = 0; i < NumChild;i++) { NodoTree treechild = new
		 * NodoTree(NumChild,Deep); children2.add(treechild);
		 * 
		 * }
		 */
	}
	
	@GetMapping(path = "/tree")
	public ResponseEntity<?> tree(@RequestParam(name= "c") Integer child, @RequestParam(name= "d") Integer deep){

		return serv.treeServ(child,deep);
	}
	
	public Integer NumChildrens() {
		Integer val = 0;
		
		while (val < 2 || val > 6) {
			Double val1 = Math.floor(Math.random()*10);
			val = val1.intValue();
		}
		
		return val;
	}
	
	public Integer Deep() {
		Integer val = 0;
		
		while (val < 2 || val > 6) {
			Double val1 = Math.floor(Math.random()*10);
			val = val1.intValue();
		}
		
		return val;
	}
	
	public List<NodoTree> getChildren() {
		return children;
	}
	public void setChildren(List<NodoTree> children) {
		this.children = children;
	}
	public Integer getNumChildrens() {
		return NumChildrens;
	}
	public void setNumChildrens(Integer numChildrens) {
		NumChildrens = numChildrens;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getDeep() {
		return Deep;
	}
	public void setDeep(Integer deep) {
		Deep = deep;
	}
}
