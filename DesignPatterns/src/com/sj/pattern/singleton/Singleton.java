package com.sj.pattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

	private static final long serialVersionUID = 4415040962367413861L;

	private volatile static Singleton instance = null;
	
	private int instanceId = 1;
	
	private Singleton()
	{
		if(instance!=null) {
			throw new RuntimeException(Thread.currentThread().getName()+"Instance already created");
		}
	}
	
	protected Object readResolve() {
		if(instance == null)
			instance = this; //when in diff. JVM
		return instance;
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	public synchronized void printInstanceAndIncrement() {
		System.out.println(Thread.currentThread().getName()+"-InstanceId of Singleton-"+instanceId);
		instanceId++;
	}
	
}
