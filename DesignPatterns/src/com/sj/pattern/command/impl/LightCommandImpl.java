package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.vendors.Light;

public class LightCommandImpl implements ICommand {
	
	private Light light;
	
	public LightCommandImpl(String type) {
		light = new Light(type);
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

}
