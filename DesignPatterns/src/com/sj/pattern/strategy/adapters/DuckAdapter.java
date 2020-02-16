package com.sj.pattern.strategy.adapters;

import com.sj.pattern.strategy.ducks.AbstractDuck;
import com.sj.pattern.strategy.turkeys.AbstractTurkey;

public class DuckAdapter extends AbstractTurkey {
	
	private AbstractDuck duck;
	
	public DuckAdapter(AbstractDuck duck) {
		super("turkey-cum-duck");
		this.duck = duck;
	}

	@Override
	public void display() {
		System.out.println("Displaying turkey-cum-duck..i.e...");
		duck.display();
	}
	
	@Override
	public void doGobble() {
		duck.doQuack();
	}
	
	@Override
	public void doFly() {
		duck.doFly();
	}

}
