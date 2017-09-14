package com.sj.ds.queue;

public class QueueImpl<T> implements Queue<T> {

	private Object[] items;
	private int head;
	private int tail;
	
	public QueueImpl(int max){
		items = new Object[max+1];
		head = -1;
		tail = 0;
	}
	
	@Override
	public boolean insert(T i) {
		if(isFull())
			return false;
		if(head==items.length-1)
			head = -1;
		items[++head] = i;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
		if(isEmpty())
			return null;
		T item = (T) items[tail++];  //case when initially tail=0 & head=-1, is handled by isEmpty
		items[tail-1] = null;
		if(tail==items.length)
			tail=0;
		
		
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if(isEmpty())
			return null;
		return (T) items[tail];
	}

	@Override
	public boolean isFull() {
		return size()==items.length-1;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public int size() {
		if(head+1==tail || tail+items.length-1==head)
			return 0;
		
		if(head+2==tail || (tail+items.length-2==head))
			return items.length-1;
		
		if(head>=tail)
			return head-tail-1;
		
		if((tail+1)>=items.length)
			return head;
		
		return (items.length+head-tail-1);
	}

}
