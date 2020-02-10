package com.sj.pattern.command.vendors;

public class Light {
	
	private String type = null;
	
	public Light(String type) {
		this.type = type;
	}
	
	public void on() {
		System.out.println(type+" Light is on");
	}
	
	public void off() {
		System.out.println(type+" Light is off");
	}

}
