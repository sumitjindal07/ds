package com.sj.pattern.strategy;

import com.sj.pattern.strategy.ducks.AbstractDuck;
import com.sj.pattern.strategy.ducks.GreenNoWingsMuteDuck;
import com.sj.pattern.strategy.ducks.RedNoWingsSqueekDuck;
import com.sj.pattern.strategy.ducks.WhiteFlyingLoudDuck;

public class DuckTales {

	public static void main(String[] args) {
		duckPerformance(new WhiteFlyingLoudDuck());
		
		duckPerformance(new RedNoWingsSqueekDuck());
		
		duckPerformance(new GreenNoWingsMuteDuck());
	}
	
	static void duckPerformance(AbstractDuck duck){
		duck.display();
		duck.swim();
		duck.doQuack();
		duck.doFly();
	}
}
