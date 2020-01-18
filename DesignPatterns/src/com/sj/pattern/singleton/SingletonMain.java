package com.sj.pattern.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		Thread[] arrs = new Thread[10];
		for (int i=0; i<10; i++) {
			arrs[i] = new Thread(new CreateSingleton(), "cs"+(i+1));
		}
		
		for (int i=0; i<10; i++) {
			arrs[i].start();
		}
	}
	
	static class CreateSingleton implements Runnable {
		@Override
		public void run() {
			try {
				Singleton s = Singleton.getInstance();
				s.printInstanceAndIncrement();
			}catch (Exception e) {
				System.out.println(Thread.currentThread().getName()+"-Exception-"+e.getMessage());
			}
		}
	}
}
