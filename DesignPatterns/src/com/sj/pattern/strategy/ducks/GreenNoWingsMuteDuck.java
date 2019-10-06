package com.sj.pattern.strategy.ducks;

import com.sj.pattern.strategy.fly.FlyNoWay;
import com.sj.pattern.strategy.quacks.QuackMute;

public class GreenNoWingsMuteDuck extends AbstractDuck {

	public GreenNoWingsMuteDuck() {
		super("GreenNoWingsMuteDuck");
		setFly(new FlyNoWay());
		setQuack(new QuackMute());
	}
	
	@Override
	public void display() {
		System.out.println("Displaying Green Not Flying Mute duck");

	}

}
