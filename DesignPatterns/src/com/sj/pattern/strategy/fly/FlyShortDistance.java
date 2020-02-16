package com.sj.pattern.strategy.fly;

public class FlyShortDistance implements FlyBehaviour {

	private FlyShortDistance() {}
	private static FlyShortDistance instance;
	public static FlyShortDistance getInstance() {
		if(instance==null)
			instance = new FlyShortDistance();
		return instance;
	}
	
	@Override
	public void fly(String name) {
		System.out.println(name+" is flying short distance");
	}

}