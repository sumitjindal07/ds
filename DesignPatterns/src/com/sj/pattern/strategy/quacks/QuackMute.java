package com.sj.pattern.strategy.quacks;

public class QuackMute implements QuackBehaviour {

	@Override
	public void quack(String name) {
		System.out.println(name+ " cannot quack");
	}

}
