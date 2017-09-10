package com.sj.algo.sort;

import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {

	T[] eu;
	Comparator<T> comp;
	
	public InsertionSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using InsertionSort:");
		for(int out=1; out<eu.length; out++){
			T c = eu[out];
			int in;
			for(in=out-1; in>=0; in--){
				if(comp.compare(eu[in], c)>0){
					eu[in+1] = eu[in];
				}else 
					break;
			}
			eu[in+1] = c;
		}
	}
	
	public void sort1() {
		System.out.println("Using InsertionSort:");
		for(int out=1; out<eu.length; out++){
			T c = eu[out];
			int in = out-1;
			while(in>=0 && comp.compare(eu[in], c)>0){
				eu[in+1] = eu[in];
				in--;
			}
			eu[in+1] = c;
			
		}
	}

}
