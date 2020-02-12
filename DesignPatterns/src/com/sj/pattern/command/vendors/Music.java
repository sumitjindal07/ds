package com.sj.pattern.command.vendors;

public class Music {
	
	private int volume = 3;
	public enum STATE {ON, OFF;};
	private STATE currentState = STATE.OFF;
	
	public void on() {
		currentState = STATE.ON;
		System.out.println("Music is on");
		volume = 3;
	}
	
	public void off() {
		currentState = STATE.OFF;
		System.out.println("Music is off");
	}
	
	public STATE getCurrentState() {
		return currentState;
	}
	
	public void increaseVolume() {
		if(++volume>5)
			volume=1;
		System.out.println("Music volume is set to "+volume);
	}
	
	@Override
	public String toString() {
		return "Music at state "+currentState+((currentState==STATE.ON)?" and at volume "+volume:"");
	}

}
