package com.sj.pattern.command.impl;

import com.sj.pattern.command.ICommand;

public class NoCommand implements ICommand {

	@Override
	public boolean executeOn() {
		return false;
	}

	@Override
	public boolean executeOff() {
		return false;
	}

	@Override
	public boolean undo() {
		return false;
	}

	@Override
	public String toString() {
		return "[No Command]";
	}

	@Override
	public String toStringSimple() {
		return toString();
	}
}
