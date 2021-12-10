package com.sj.ds.ll;

public class LLMain {

	public static void main(String[] args) {
		
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();
		System.out.println(ll);
		ll.insert("A");
		System.out.println(ll);
		ll.insertTail("B");
		System.out.println(ll);
		ll.insertTail("D");
		System.out.println(ll);
		ll.insertTail("F");
		System.out.println(ll);
		ll.insertTail("G");
		System.out.println(ll);
		ll.insert("C", 2);
		System.out.println(ll);
		
	}
}
