package com.sj.pattern.strategy.fly;

public class FlyNoWay implements FlyBehaviour {

	private FlyNoWay() {}
	private static FlyNoWay instance;
	public static FlyNoWay getInstance() {
		if(instance==null)
			instance = new FlyNoWay();
		return instance;
	}
	
	@Override
	public void fly(String name) {
		System.out.println(name +"  cannot fly");
	}
	
}