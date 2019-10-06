package com.sj.pattern.strategy.ducks;

import com.sj.pattern.strategy.fly.FlyNoWay;
import com.sj.pattern.strategy.quacks.QuackSqueek;

public class RedNoWingsSqueekDuck extends AbstractDuck {

	public RedNoWingsSqueekDuck() {
		super("RedNoWingsSqueekDuck");
		setFly(FlyNoWay.getInstance());
		setQuack(QuackSqueek.getInstance());
	}
	
	@Override
	public void display() {
		System.out.println("Displaying Red Not Flying Squeek duck");
	}

}