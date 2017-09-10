package com.sj.algo.sort;

import java.util.Comparator;

public class BubbleSort<T> implements Sort<T> {

	T[] eu;
	Comparator<T> comp;
	
	public BubbleSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using BubbleSort:");
		for(int out=eu.length-1; out>=0; out--){
			for(int in=0; in<out; in++){
				T i = eu[in];
				T j = eu[in+1];
				if(comp.compare(i, j)>0)
					Sort.swap(eu, in, in+1);
			}
		}
		
	}

}
