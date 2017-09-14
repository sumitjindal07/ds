package com.sj.ds.stack;

public class StackException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StackException(String message) {
		super(message);
	}


	public static void throwStackFullException(int cur, int max) throws StackFullException{
		throw new StackFullException(cur, max);
	}
	
	public static void throwStackEmptyException(int cur, int max) throws StackEmptyException{
		throw new StackEmptyException(cur, max);
	}
	
	
	private static class StackFullException extends StackException{
		
		
		private static final long serialVersionUID = 1L;

		public StackFullException(int cur, int max) {
			super("Stack is full. Max size is="+max+", cur index="+cur);
		}
	}
	
	private static class StackEmptyException extends StackException{
		
		
		private static final long serialVersionUID = 1L;

		public StackEmptyException(int cur, int max) {
			super("Stack is empty. Cur index is " + cur);
		}
	}

	
}
