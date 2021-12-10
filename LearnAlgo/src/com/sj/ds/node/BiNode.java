package com.sj.ds.node;

public class BiNode<T> extends Node<T> {

	private Node<T> prev;
	
	public BiNode(T data) {
		super(data);
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
}
