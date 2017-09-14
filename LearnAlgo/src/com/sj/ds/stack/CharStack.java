package com.sj.ds.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CharStack implements Stack<Character> {

	private char[] chars;
	private int cur = -1;
	
	public CharStack(int max){
		chars = new char[max];
		cur = -1;
	}
	
	@Override
	public void push(Character t) throws StackException {
		if(isFull())
			StackException.throwStackFullException(cur, chars.length);
		
		chars[++cur] = t;
		
	}

	@Override
	public Character pop() throws StackException {
		if(isEmpty())
			StackException.throwStackEmptyException(cur, chars.length);
		
		return chars[cur--];
	}
	
	@Override
	public boolean isFull() {
		return cur>=chars.length-1;
	}
	@Override
	public boolean isEmpty() {
		return cur<0;
	}

	@Override
	public int size() {
		return cur+1;
	}

	public boolean contains(Character t) throws NullPointerException {
		for(char c:chars)
			if(c==t)
				return true;
		return false;
	}

	@Override
	public Iterator<Character> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<Character>{
		
		int ctr = cur;
		int expCur = cur; //to simplify, just using cur as modcount
		
		@Override
		public boolean hasNext() {
			if(expCur!=cur)
				throw new ConcurrentModificationException();
			return (ctr>=0);
		}

		@Override
		public Character next() {
			if(expCur!=cur)
				throw new ConcurrentModificationException();
			return chars[ctr--];
		}
		
	}
}
