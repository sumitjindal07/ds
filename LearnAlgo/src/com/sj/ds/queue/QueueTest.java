package com.sj.ds.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new QueueImpl<>(10);
		
		char c = 'a';
		while(q.insert(""+(c++)));
		
		System.out.println("Size:"+q.size());
		
		do{
			System.out.print(q.remove()+",");
		}while(q.peek()!=null);
		
		System.out.println("\nSize:"+q.size());
		

	}

}
