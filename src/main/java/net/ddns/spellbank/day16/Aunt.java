package net.ddns.spellbank.day16;

import java.util.HashMap;
import java.util.Map;

public class Aunt {
	int id;
	private Map<String, Integer> props;
	
	public Aunt(int id) {
		this.id = id;
		props = new HashMap<>();
	}
	
	public void setProperty(String name, int val) {
		props.put(name, val);
	}
	
	public Integer getProperty(String name) {
		return props.get(name);
	}
	
	public void print() {
		System.out.println(id);
		for (String s : props.keySet()) System.out.println(s + " " + props.get(s));
	}

}
