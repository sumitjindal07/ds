package com.sj.pattern.strategy;

import com.sj.pattern.strategy.adapters.DuckAdapter;
import com.sj.pattern.strategy.ducks.WhiteFlyingLoudDuck;
import com.sj.pattern.strategy.turkeys.AbstractTurkey;
import com.sj.pattern.strategy.turkeys.WildTurkey;

public class TurkeyTales {

	public static void main(String[] args) {
		
		AbstractTurkey turkey = new WildTurkey();
		
		turkeyPerformance(turkey);
		
		turkey = new DuckAdapter(new WhiteFlyingLoudDuck());
		
		turkeyPerformance(turkey);
		
	}
	
	static void turkeyPerformance(AbstractTurkey turkey){
		turkey.display();
		turkey.doGobble();
		turkey.doFly();
	}
}
