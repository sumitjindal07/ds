package com.sj.pattern.strategy.gobbles;

public class GobbleLoudly implements GobbleBehaviour {

	private GobbleLoudly() {}
	private static GobbleLoudly instance;
	public static GobbleLoudly getInstance() {
		if(instance==null)
			instance = new GobbleLoudly();
		return instance;
	}
	
	@Override
	public void gobble(String name) {
		System.out.println(name+" is gobbling loudlyyyyy");
	}
	
}