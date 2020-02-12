package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.vendors.Light;

public class LightCommandImpl implements ICommand {
	
	private Light light;
	
	public LightCommandImpl(Light light) {
		this.light = light;
	}
	
	enum STATE {ON, OFF;};
	private STATE currentState = null;
	
	@Override
	public boolean executeOn() {
		if(currentState==null || currentState==STATE.OFF) {
			light.on();
			currentState = STATE.ON;
			return true;
		}
		return false;
	}

	@Override
	public boolean executeOff() {
		if(currentState==STATE.ON) {
			light.off();
			currentState = STATE.OFF;
			return true;
		}
		return false;
	}

	@Override
	public boolean undo() {
		if(currentState==null)
			return false;
		switch(currentState) {
		case OFF:
			return executeOn();
		case ON:
			return executeOff();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "["+light.toString()+" with state "+currentState+"]"+" Buttons [ON] and [OFF]";
	}
}
