package com.sj.algo.sort;

import java.util.Comparator;

public class SortFactory {

	public static <T> Sort<T> getSortImpl(SortStrategy strategy, T[] eu, Comparator<T> comp){
		switch(strategy){
			case BUBBLE:
				return new BubbleSort<T>(eu, comp);
			case SELECTION:
				return new SelectionSort<T>(eu, comp);
			case INSERTION:
				return new InsertionSort<T>(eu, comp);
			case MERGE:
				return new MergeSort<T>(eu, comp);
			default:
				return null;
		}
	}
}
