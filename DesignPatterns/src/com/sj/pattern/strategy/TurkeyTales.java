package com.sj.pattern.strategy;

import com.sj.pattern.strategy.turkeys.AbstractTurkey;
import com.sj.pattern.strategy.turkeys.WildTurkey;

public class TurkeyTales {

	public static void main(String[] args) {
		turkeyPerformance(new WildTurkey());
		
	}
	
	static void turkeyPerformance(AbstractTurkey turkey){
		turkey.display();
		turkey.doGobble();
		turkey.doFly();
	}
}
