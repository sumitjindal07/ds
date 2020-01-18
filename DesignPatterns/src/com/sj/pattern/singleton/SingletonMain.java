package com.sj.pattern.singleton;

import java.util.HashSet;
import java.util.Set;

public class SingletonMain {
	public static void main(String[] args) {
		Thread[] arrs = new Thread[10];
		Set<Singleton> singletonSet = new HashSet<>();
		
		for (int i=0; i<10; i++) {
			arrs[i] = new Thread(new CreateSingleton(singletonSet), "cs"+(i+1));
		}
		
		for (int i=0; i<10; i++) {
			arrs[i].start();
		}
		
		for (int i=0; i<10; i++) {
			try {
				arrs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main-Count of singletonSet="+singletonSet.size());
	}
	
	static class CreateSingleton implements Runnable {
		
		Set<Singleton> singletonSet = null;
		private CreateSingleton(Set<Singleton> singletonSet) {
			this.singletonSet = singletonSet;
		}
		
		@Override
		public void run() {
			try {
				Singleton s = Singleton.getInstance();
				s.printInstanceAndIncrement();
				singletonSet.add(s);
			}catch (Exception e) {
				System.out.println(Thread.currentThread().getName()+"-Exception-"+e.getMessage());
			}
		}
	}
}
