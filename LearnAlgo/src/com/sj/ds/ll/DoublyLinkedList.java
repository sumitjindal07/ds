package com.sj.ds.ll;

import com.sj.ds.node.BiNode;
import com.sj.ds.node.Node;

public class DoublyLinkedList<T> implements ILinkedList<T, BiNode<T>> {

	private BiNode<T> head;
	private BiNode<T> tail;
	private int size = 0;
	
	@Override
	public void insert(T data) {
		if(data==null)
			return;
		insert(new BiNode<T>(data));
	}
	
	@Override
	public void insertTail(T data) {
		if(data==null)
			return;
		insertTail(new BiNode<T>(data));
	}
	
	@Override
	public void insert(T data, int pos) {
		if(data==null || pos<0)
			return;
		insert(new BiNode<T>(data), pos);
	}
	
	@Override
	public void insert(BiNode<T> node) {
		
		if(node==null)
			return;
		
		node.setNext(null);
		node.setPrev(null);
		
		if(size==0)
		{
			tail = node;
		}
		else
		{
			node.setNext(head);
			head.setPrev(node);
		}

		head = node;
		size++;
	}

	@Override
	public void insert(BiNode<T> node, int pos) {
		if(pos==0)
			insert(node);
		else if(pos==size)
			insertTail(node);
		else if(pos>size)
			return;
		else if(pos>0 && pos<size && node!=null)
		{
			Node<T> c = head;
			for(int i=0; i<pos; i++)
				c = c.getNext();
			size++;
			
			BiNode<T> curNxt = (BiNode<T>) c.getNext();
			node.setNext(curNxt);
			node.setPrev(c);
			c.setNext(node);
			curNxt.setPrev(node);
		}
		
	}
	
	@Override
	public void insertTail(BiNode<T> node) {
		if(size==0)
			insert(node);
		else if(node!=null)
		{
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			size++;
		}
		
		
	}
	@Override
	public void delete(BiNode<T> node) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public BiNode<T> getHead() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BiNode<T> getTail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(size!=0)
		{
			Node<T> curr = head;
			while(curr!=null)
			{
				sb.append(curr).append(" -> ");
				curr = curr.getNext();
			}
		}
		sb.append(']');
		return sb.toString();
	}
	
	
	
}
