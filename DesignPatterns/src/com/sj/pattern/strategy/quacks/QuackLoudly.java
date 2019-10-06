package com.sj.pattern.strategy.quacks;

public class QuackLoudly implements QuackBehaviour {

	@Override
	public void quack(String name) {
		System.out.println(name+" is quacking loudlyyyyy");
	}

}
