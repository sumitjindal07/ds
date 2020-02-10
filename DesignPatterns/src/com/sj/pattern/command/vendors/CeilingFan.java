package com.sj.pattern.command.vendors;

public class CeilingFan {
	
	public enum STATE {ON, OFF;};
	public enum SPEED {LOW, MEDIUM, HIGH;};
	
	private STATE currentState = STATE.OFF;
	private SPEED currentSpeed = null;
	
	public void on() {
		currentState = STATE.ON;
		if(currentSpeed==null)
			currentSpeed = SPEED.LOW;
		System.out.println("CeilingFan is switched ON at "+currentSpeed+" speed!");
	}
	
	public void off() {
		currentState = STATE.OFF;
		System.out.println("CeilingFan is switched OFF!");
	}
	
	public STATE getCurrentState() {
		return currentState;
	}
	public SPEED getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void increaseSpeed() {
		if(currentState==STATE.ON)
		{
			switch(currentSpeed) {
			case LOW:
				currentSpeed = SPEED.MEDIUM;
				break;
			case MEDIUM:
				currentSpeed = SPEED.HIGH;
				break;
			case HIGH:
				break;
			}
			System.out.println("CeilingFan speed is set to "+currentSpeed);
		}
	}
	
	public void decreaseSpeed() {
		if(currentState==STATE.ON)
		{
			switch(currentSpeed) {
			case HIGH:
				currentSpeed = SPEED.MEDIUM;
				break;
			case MEDIUM:
				currentSpeed = SPEED.LOW;
				break;
			case LOW:
				off();
				currentSpeed = null;
				break;
			}
			
			if(currentSpeed != null)
				System.out.println("CeilingFan speed is set to "+currentSpeed);
		}
	}
}
