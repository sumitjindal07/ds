package com.sj.pattern.strategy.fly;

public class FlyWithWings implements FlyBehaviour {

	private FlyWithWings() {}
	private static FlyWithWings instance;
	public static FlyWithWings getInstance() {
		if(instance==null)
			instance = new FlyWithWings();
		return instance;
	}
	
	@Override
	public void fly(String name) {
		System.out.println(name+" is flying with wings");
	}

}