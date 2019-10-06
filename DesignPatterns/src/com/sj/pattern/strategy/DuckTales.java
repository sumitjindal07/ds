package com.sj.pattern.strategy;

import com.sj.pattern.strategy.ducks.AbstractDuck;
import com.sj.pattern.strategy.ducks.DynamicDuck;
import com.sj.pattern.strategy.ducks.GreenNoWingsMuteDuck;
import com.sj.pattern.strategy.ducks.RedNoWingsSqueekDuck;
import com.sj.pattern.strategy.ducks.WhiteFlyingLoudDuck;
import com.sj.pattern.strategy.fly.FlyWithWings;
import com.sj.pattern.strategy.quacks.QuackLoudly;
import com.sj.pattern.strategy.quacks.QuackSqueek;

public class DuckTales {

	public static void main(String[] args) {
		duckPerformance(new WhiteFlyingLoudDuck());
		
		duckPerformance(new RedNoWingsSqueekDuck());
		
		duckPerformance(new GreenNoWingsMuteDuck());
		
		DynamicDuck dynDuck = new DynamicDuck();
		duckPerformance(dynDuck);
		
		System.out.println("After 1 year");
		dynDuck.setFly(FlyWithWings.getInstance());
		dynDuck.setQuack(QuackSqueek.getInstance());
		duckPerformance(dynDuck);
		
		System.out.println("After 2 years");
		dynDuck.setQuack(QuackLoudly.getInstance());
		duckPerformance(dynDuck);
	}
	
	static void duckPerformance(AbstractDuck duck){
		duck.display();
		duck.swim();
		duck.doQuack();
		duck.doFly();
	}
}
