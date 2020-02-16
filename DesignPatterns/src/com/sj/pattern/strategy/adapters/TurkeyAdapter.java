package com.sj.pattern.strategy.adapters;

import com.sj.pattern.strategy.ducks.AbstractDuck;
import com.sj.pattern.strategy.turkeys.AbstractTurkey;

public class TurkeyAdapter extends AbstractDuck {
	
	private AbstractTurkey turkey;
	
	public TurkeyAdapter(AbstractTurkey turkey) {
		super("duck-cum-turkey");
		this.turkey = turkey;
	}

	@Override
	public void display() {
		System.out.println("Displaying duck-cum-turkey..i.e...");
		turkey.display();
	}
	
	@Override
	public void doQuack() {
		turkey.doGobble();
	}
	
	@Override
	public void doFly() {
		turkey.doFly();
	}
	
	@Override
	public void swim() {
		//No operation
	}
}
