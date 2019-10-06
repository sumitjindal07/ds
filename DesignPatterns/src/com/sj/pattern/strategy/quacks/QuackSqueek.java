package com.sj.pattern.strategy.quacks;

public class QuackSqueek implements QuackBehaviour {

	@Override
	public void quack(String name) {
		System.out.println(name+" is squeeking");
	}

}
