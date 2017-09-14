package com.sj.ds.queue;

public interface Queue<T> {
	public boolean insert(T i);
	
	public T remove();
	
	public T peek();
	
	public boolean isFull();
	
	public boolean isEmpty();
	
	public int size();
}
