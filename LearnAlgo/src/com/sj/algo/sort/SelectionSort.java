package com.sj.algo.sort;

import java.util.Comparator;

public class SelectionSort<T> implements Sort<T> {

	T[] eu;
	Comparator<T> comp;
	
	public SelectionSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using SelectionSort:");
		for(int out=eu.length-1; out>=0; out--){
			int maxIndex = out;
			for(int in=0; in<out; in++){
				T max = eu[maxIndex];
				T i = eu[in];
				if(comp.compare(i, max)>=0)
					maxIndex = in;
			}
			Sort.swap(eu, maxIndex, out);
		}
		
	}

}
