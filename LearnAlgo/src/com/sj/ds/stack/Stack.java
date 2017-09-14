package com.sj.ds.stack;

public interface Stack<T> extends Iterable<T> {

	public void push(T t) throws StackException;
	
	public T pop() throws StackException;
	
	public boolean isFull();
	public boolean isEmpty();
	
	public boolean contains(T t);

	int size();

	
}
