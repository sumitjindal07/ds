package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.vendors.CeilingFan;
import com.sj.pattern.command.vendors.CeilingFan.SPEED;

public class CeilingFanCommandImpl implements ICommand {
	
	private CeilingFan fan;
	
	enum STATE {ON, OFF;};
	private STATE currentState = STATE.OFF;
	
	public CeilingFanCommandImpl() {
		fan = new CeilingFan();
	}
	
	@Override
	public boolean executeOn() {
		switch(fan.getCurrentState()) {
		case OFF:
			fan.on();
			break;
		case ON:
			if(fan.getCurrentSpeed()!=SPEED.HIGH) {
				fan.increaseSpeed();
			}else {
				return false;
			}
		}
		currentState = STATE.ON;
		return true;
	}

	@Override
	public boolean executeOff() {
		switch(fan.getCurrentState()) {
		case OFF:
			return false;
		case ON:
			fan.decreaseSpeed();
		}
		currentState = STATE.OFF;
		return true;
	}

	@Override
	public boolean undo() {
		switch(currentState) {
		case OFF:
			return executeOn();
		case ON:
			return executeOff();
		}
		return false;
	}

}
