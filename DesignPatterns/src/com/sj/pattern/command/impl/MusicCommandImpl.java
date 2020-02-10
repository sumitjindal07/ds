package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.vendors.Music;

public class MusicCommandImpl implements ICommand {
	
	private Music music;
	
	public MusicCommandImpl() {
		music = new Music();
	}
	
	enum STATE {ON, OFF, VOLUME;};
	private STATE currentState = STATE.OFF;
	
	@Override
	public boolean executeOn() {
		switch(music.getCurrentState()) {
		case OFF:
			music.on();
			currentState = STATE.ON;
			break;
		case ON:
			music.increaseVolume();
			currentState = STATE.VOLUME;
			break;
		}
		return true;
	}

	@Override
	public boolean executeOff() {
		switch(currentState) {
		case ON:
		case VOLUME:
			currentState = STATE.OFF;
			music.off();
			return true;
		case OFF:
			return false;
		}
		return false;
	}

	@Override
	public boolean undo() {
		switch(currentState) {
		case OFF:
			return executeOn();
		case ON:
			return executeOff();
		case VOLUME:
			break;
		}
		return false;
	}

}
