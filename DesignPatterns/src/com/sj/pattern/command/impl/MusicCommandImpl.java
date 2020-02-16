package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.vendors.Music;

public class MusicCommandImpl implements ICommand {
	
	private Music music;
	
	public MusicCommandImpl(Music music) {
		this.music = music;
	}
	
	enum STATE {ON, OFF, VOLUME;};
	private STATE currentState = null;
	
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
		switch(music.getCurrentState()) {
		case ON:
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
		if(currentState==null)
			return false;
		switch(currentState) {
		case OFF:
			return executeOn();
		case ON:
			return executeOff();
		case VOLUME:
			System.out.println("Cannot undo volume change!!");
			return true;
			
		}
		return false;
	}

	@Override
	public String toString() {
		return toStringSimple()+" Buttons [ON/VOLUME] and [OFF]";
	}
	
	@Override
	public String toStringSimple() {
		return "["+music.toString()+"]";
	}
}
