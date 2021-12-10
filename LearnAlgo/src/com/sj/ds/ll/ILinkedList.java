package com.sj.ds.ll;

import com.sj.ds.node.Node;

public interface ILinkedList<T, N extends Node<T>> {
	
	void insert(T data);
	void insertTail(T data);
	void insert(T date, int pos);
	
	void insert(N node);
	void insert(N node, int pos);
	void insertTail(N node);
	
	void delete(N node);
	void delete(int pos);
	
	int size();

	N getHead();
	N getTail();
}
