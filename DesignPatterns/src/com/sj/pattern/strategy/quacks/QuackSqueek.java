package com.sj.pattern.strategy.quacks;

public class QuackSqueek implements QuackBehaviour {

	private QuackSqueek() {}
	private static QuackSqueek instance;
	public static QuackSqueek getInstance() {
		if(instance==null)
			instance = new QuackSqueek();
		return instance;
	}
	
	@Override
	public void quack(String name) {
		System.out.println(name+" is squeeking");
	}
	
}