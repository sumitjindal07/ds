package com.sj.pattern.strategy.fly;

public class FlyNoWay implements FlyBehaviour {

	@Override
	public void fly(String name) {
		System.out.println(name +"  cannot fly");

	}

}
