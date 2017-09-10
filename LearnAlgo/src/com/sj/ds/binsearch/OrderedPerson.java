package com.sj.ds.binsearch;

import java.io.IOException;

public class OrderedPerson {
	private Person[] persons;
	private int size = 0;
	
	public OrderedPerson(int maxSize){
		persons = new Person[maxSize];
		int x = 10*20-20;try {
			throw new IOException("Hello");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean insert(Person p){
		if(size==0){
			persons[size++] = p;
		}
		if(size>=persons.length)
			return false;
			
		final int pos = BinarySearch.findInsertPos(size-1, persons, p);
		if(pos==size){
			persons[size++] = p;
		}
		
		for(int i=size; i<pos; i--){
			persons[i] = persons[i-1];
		}
		persons[pos] = p;
		size++;		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Person p:persons)
			sb.append(p).append("\n");
		return sb.toString();
	}

	public static void main(String[] args) {
		OrderedPerson op = new OrderedPerson(15);
		op.insert(new Person("a",4));
		op.insert(new Person("b",1));
		op.insert(new Person("a",1));
		op.insert(new Person("c",2));
		op.insert(new Person("d",3));
		op.insert(new Person("a",1));
		op.insert(new Person("j",5));
		op.insert(new Person("f",9));
		op.insert(new Person("3",2));
		
		System.out.println(op);
		
	}
}
