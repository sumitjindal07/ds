package com.sj.pattern.strategy.fly;

public class FlyWithWings implements FlyBehaviour {

	@Override
	public void fly(String name) {
		System.out.println(name+" is flying with wings");

	}

}
