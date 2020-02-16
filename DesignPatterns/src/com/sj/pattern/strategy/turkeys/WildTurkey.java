package com.sj.pattern.strategy.turkeys;

import com.sj.pattern.strategy.fly.FlyShortDistance;
import com.sj.pattern.strategy.gobbles.GobbleLoudly;

public class WildTurkey extends AbstractTurkey {

	public WildTurkey() {
		super("WildTurkey");
		setFly(FlyShortDistance.getInstance());
		setGobble(GobbleLoudly.getInstance());
	}
	
	@Override
	public void display() {
		System.out.println("Displaying Wild Turkey");
	}

}