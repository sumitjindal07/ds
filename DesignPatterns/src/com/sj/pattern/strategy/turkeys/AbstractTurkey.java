package com.sj.pattern.strategy.turkeys;

import com.sj.pattern.strategy.fly.FlyBehaviour;
import com.sj.pattern.strategy.gobbles.GobbleBehaviour;

public abstract class AbstractTurkey {

	private String name;
	private FlyBehaviour fly;
	private GobbleBehaviour gobble;

	public AbstractTurkey(String name) {
		this.name = name;
	}

	protected void setFly(FlyBehaviour fly) {
		System.out.println("AbstractTurkey Setting fly:"+fly.getClass().getName());
		this.fly = fly;
	}

	protected void setGobble(GobbleBehaviour gobble) {
		System.out.println("AbstractTurkey Setting gobble:"+gobble.getClass().getName());
		this.gobble = gobble;
	}

	public abstract void display();

	public void doFly() {
		if(fly!=null)
			fly.fly(name);
	}

	public void doGobble() {
		if(gobble!=null)
			gobble.gobble(name);
	}
}
