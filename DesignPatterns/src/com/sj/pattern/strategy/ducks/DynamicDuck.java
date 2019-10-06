package com.sj.pattern.strategy.ducks;

import com.sj.pattern.strategy.fly.FlyBehaviour;
import com.sj.pattern.strategy.fly.FlyNoWay;
import com.sj.pattern.strategy.quacks.QuackBehaviour;
import com.sj.pattern.strategy.quacks.QuackMute;

public class DynamicDuck extends AbstractDuck {

	public DynamicDuck() {
		super("DynamicDuck");
		setFly(FlyNoWay.getInstance());
		setQuack(QuackMute.getInstance());
	}

	@Override
	public void setFly (FlyBehaviour fly) {
		System.out.println("DynamicDuck Setting fly:"+fly.getClass().getName());
		super.setFly(fly);
	}

	@Override
	public void setQuack(QuackBehaviour quack) {
		System.out.println("DynamicDuck Setting quack:"+quack.getClass().getName());
		super.setQuack(quack);
	}
	
	@Override
	public void display() {
		System.out.println("Displaying dynamic duck");
	}

}
