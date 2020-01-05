package com.sj.pattern.decorator.map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

public class MyBiMap<K> extends AbstractMap<K, K> {
	
	private final AbstractMap<K, K> map;
	
	public MyBiMap() {
		this.map = new HashMap<>(); 
	}
	
	public MyBiMap(AbstractMap<K, K> map) {
		this.map = map; 
	}

	@Override
	public Set<Entry<K, K>> entrySet() {
		
		return map.entrySet();
	}
	
	@Override
	public K put(K key, K value) {
		
		K oldKey = null;
		K oldValue = null;
		
		if((map.containsKey(key)) || map.containsKey(value))
		{
			map.remove(map.get(key));
			oldValue = map.remove(key);
			
			map.remove(map.get(value));
			oldKey = map.remove(value);
		}
		map.put(key, value);
		map.put(value, key);
		return (oldValue==null)?oldKey:oldValue;
	}
}
