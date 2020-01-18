package com.sj.pattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		
		Singleton ins = singletonSet.toArray(new Singleton[1])[0];
		ins.printInstanceAndIncrement();
		
		try {
			serializeSingleton(ins);
			Singleton deserializeIns = deserializeSingleton();
			
			if(ins!=deserializeIns) {
				System.out.println("another instance of Singleton is created");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Singleton deserializeSingleton() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmp"));
		Object obj = ois.readObject();
		ois.close();
		return (Singleton) obj;
	}

	private static void serializeSingleton(Singleton ins) throws IOException {
		FileOutputStream bos = new FileOutputStream("tmp");
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(ins);
		oos.close();
		if(new File("tmp").exists()) {
			System.out.println("Serialization of "+ins+" is done!!!");
		} else {
			System.out.println("Serialization of "+ins+" is NOT done!!!");
		}
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
