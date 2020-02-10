package com.sj.pattern.command;

public interface ICommand {
	public boolean executeOn();
	public boolean executeOff();
	public boolean undo();
}
