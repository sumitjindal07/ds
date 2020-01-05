package com.sj.pattern.decorator.map;

import java.util.Map;

public class TestMyBiMap {

	public static void main(String[] args) {
		Map<String, String> map = new MyBiMap<String>();
		fillMap(map);
		System.out.println(map);
		
		System.out.println(map.put("1", "C"));
		
		System.out.println(map);
		
		fillMap(map);
		
		System.out.println(map);
		
		System.out.println(map.put("1", "B"));
		
		System.out.println(map);
		
		System.out.println(map.put("B", "3"));
		
		System.out.println(map);
		
	}

	private static void fillMap(Map<String, String> map) {
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
	}

	
}
