package com.sj.algo.sort;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

	private T[] eu;
	private Comparator<T> comp;
	
	public QuickSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using QuickSort:");
		quicksort(0, eu.length-1);
	}

	private void quicksort(int start, int end) {
		if(start>=end)
			return;
		int len = end-start+1;
		if(len==2){
			if(comp.compare(eu[start],  eu[end])>0)
				Sort.swap(eu, start, end);
			return;
		}
		if(len==3){
			sortThree(start, start+1, end);
			return;
		}
		
		int partitionIndex = partition(start, end);
		quicksort(start, partitionIndex-1);
		quicksort(partitionIndex+1, end);
	}

	private int partition(int start, int end) {
		int mid = (start+end)/2;
		sortThree(start, mid, end);
		T pivot = eu[mid];
		Sort.swap(eu, mid, end-1);  // to put pivot at safeplace so that doesn't participate in partitioning
		
		int aPtr = start;   //start is already < pivot, hence skipped in while loop
		int zPtr = end-1;  //since end-1 points to pivot, hence skipped in while loop
		
		while(true){
			while(comp.compare(eu[++aPtr], pivot)<0);
			while(comp.compare(pivot, eu[--zPtr])<0);
			//now aPtr points to elem>pivot and zPtr points to elem<pivot
			//1st check if aPtr and zPtr didn't cross 
			if(aPtr>=zPtr){
				//since crossed, aPtr points to DESIRED pivot loc 
				//But, currently aPtr pts to elem>pivot, hence need to swap as below)
				Sort.swap(eu, aPtr, end-1);  //restore pivot from safe last-1 loc to desired loc
				return aPtr;
			}//start points to pivot loc
			Sort.swap(eu, aPtr, zPtr);
		}
	}
	
	private void sortThree(int fisrt, int mid, int last){
		if(comp.compare(eu[fisrt],  eu[mid])>0)   //compare 1st and middle
			Sort.swap(eu, fisrt, mid);
		
		//now, 1st < middle
		
		if(comp.compare(eu[mid],  eu[last])>0){    //compare middle and last
			Sort.swap(eu, mid, last);
			//now, last (orig. middle b4 swap) is largest. 
			//But new middle (orig. last b4 swap) is not compared with 1st
			if(comp.compare(eu[fisrt],  eu[mid])>0)
				Sort.swap(eu, fisrt, mid);
		}//else middle (which was > 1st) is < last. ==>> 1st<last ==>> Hence sorted.
	}
	

}
