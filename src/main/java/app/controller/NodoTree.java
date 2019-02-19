package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NodoTree {
	
	private static final Logger log = LoggerFactory.getLogger(NodoTree.class);
	
	private Double value;
	private List<NodoTree> children = new ArrayList<NodoTree>() ;
	
	public NodoTree(Integer Numchild, Integer Deep) {
		// TODO Auto-generated constructor stub
		value = Math.floor(Math.random()*10)/10;
		
		Long exp = Math.round(1+Math.random()*(Numchild-1));
		log.info("exp = {}",exp);
		Integer dp = exp.intValue();
		if (Deep > 1) {
			Deep = Deep-1;
			for (int i = 0; i < dp;i++) {
				NodoTree child = new NodoTree(Numchild, Deep);
				children.add(child);
			}
		}
		
	}
	
	public List<NodoTree> getChildren() {
		return children;
	}
	public void setChildren(List<NodoTree> children) {
		this.children = children;
	}
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
