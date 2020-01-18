package com.sj.pattern.singleton;

public class Singleton {

	private volatile static Singleton instance = null;
	
	private int instanceId = 1;
	
	private Singleton()
	{
		if(instance!=null) {
			throw new RuntimeException(Thread.currentThread().getName()+"Instance already created");
		}
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public synchronized void printInstanceAndIncrement() {
		System.out.println(Thread.currentThread().getName()+"-InstanceId of Singleton-"+instanceId);
		instanceId++;
	}
	
}
