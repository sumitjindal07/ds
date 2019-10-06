package com.sj.pattern.strategy.quacks;

public class QuackMute implements QuackBehaviour {

	private QuackMute() {}
	private static QuackMute instance;
	public static QuackMute getInstance() {
		if(instance==null)
			instance = new QuackMute();
		return instance;
	}
	
	@Override
	public void quack(String name) {
		System.out.println(name+ " cannot quack");
	}

}