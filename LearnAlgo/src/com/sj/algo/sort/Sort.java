package com.sj.algo.sort;

public interface Sort<T> {

	void sort();
	
	static <T> void swap(T[] eu, int i, int j){
		T t = eu[i];
		eu[i] = eu[j];
		eu[j] = t;
	}

}
