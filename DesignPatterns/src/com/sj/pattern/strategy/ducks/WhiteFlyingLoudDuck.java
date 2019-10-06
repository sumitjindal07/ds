package com.sj.pattern.strategy.ducks;

import com.sj.pattern.strategy.fly.FlyWithWings;
import com.sj.pattern.strategy.quacks.QuackLoudly;

public class WhiteFlyingLoudDuck extends AbstractDuck {

	public WhiteFlyingLoudDuck() {
		super("WhiteFlyingLoudDuck");
		setFly(new FlyWithWings());
		setQuack(new QuackLoudly());
	}
	
	@Override
	public void display() {
		System.out.println("Displaying White Flying Loud duck");

	}

}
