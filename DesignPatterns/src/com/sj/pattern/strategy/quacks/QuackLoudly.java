package com.sj.pattern.strategy.quacks;

public class QuackLoudly implements QuackBehaviour {

	private QuackLoudly() {}
	private static QuackLoudly instance;
	public static QuackLoudly getInstance() {
		if(instance==null)
			instance = new QuackLoudly();
		return instance;
	}
	
	@Override
	public void quack(String name) {
		System.out.println(name+" is quacking loudlyyyyy");
	}
	
}