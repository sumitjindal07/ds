package com.sj.algo.sort;

import java.util.Comparator;

public class ShellSort<T> implements Sort<T> {

	T[] eu;
	Comparator<T> comp;
	
	public ShellSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using ShellSort:");
		int h = 1;
		while(h<=eu.length)
			h = 3*h+1;
		
		while(h>0){
			
			for(int outer=h; outer<eu.length; outer++){
				T temp = eu[outer];
				int inner = outer-h;
				while(inner>=0 && comp.compare(eu[inner], temp)>0){
					eu[inner+h] = eu[inner];
					inner = inner-h;
				}
				eu[inner+h] = temp;
			}
			
			
			h = (h-1)/3;
		}
	}

}
