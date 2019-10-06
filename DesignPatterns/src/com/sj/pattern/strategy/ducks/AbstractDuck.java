package com.sj.pattern.strategy.ducks;

import com.sj.pattern.strategy.fly.FlyBehaviour;
import com.sj.pattern.strategy.quacks.QuackBehaviour;

public abstract class AbstractDuck {

	private String name;
	private FlyBehaviour fly;
	private QuackBehaviour quack;

	public AbstractDuck(String name) {
		this.name = name;
	}

	protected void setFly(FlyBehaviour fly) {
		System.out.println("AbstractDuck Setting fly:"+fly.getClass().getName());
		this.fly = fly;
	}

	protected void setQuack(QuackBehaviour quack) {
		System.out.println("AbstractDuck Setting quack:"+quack.getClass().getName());
		this.quack = quack;
	}

	public abstract void display();

	public void swim() {
		System.out.println(name + " is swimming");
	}

	public void doFly() {
		if(fly!=null)
			fly.fly(name);
	}

	public void doQuack() {
		if(quack!=null)
			quack.quack(name);
	}
}
