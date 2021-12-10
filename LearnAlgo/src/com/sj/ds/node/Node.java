package com.sj.ds.node;

public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	@Override
	public String toString() {
		return data==null?"":data.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this==obj)
			return true;
		
		if(obj instanceof Node)
		{
			Node<?> objNode = (Node<?>) obj;
			if(objNode.data !=null && objNode.data.getClass().equals(data!=null?data.getClass():null))
			{
				 return objNode.data.equals(data);
			}
			else
				return (objNode.data ==null && data == null); 
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}


}
