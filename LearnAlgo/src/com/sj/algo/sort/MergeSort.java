package com.sj.algo.sort;

import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {

	private T[] eu;
	private Comparator<T> comp;
	
	public MergeSort(T[] eu, Comparator<T> comp) {
		this.eu = eu;
		this.comp = comp;
	}
	
	@Override
	public void sort() {
		System.out.println("Using MergeSort(without rec):");
		mergesortWithoutRec(0, eu.length-1);
		
		//System.out.println("Using MergeSort:");
		//mergesort(0, eu.length-1);
	}

	private void mergesortWithoutRec(int start, int end) {
		
		int size = end+1-start;
		
		int insize = 2;
		
		boolean exit = false;
		while(!exit){
			
			int step = size/insize;
			for(int i=0; i<step; i++){
				sortTwoSortedArrays((i*insize), (i*insize+insize-1));
			}
			
			int sizeOfLeftover = size%insize;
			if(sizeOfLeftover!=0)
			{
				int indexLeftover = size-sizeOfLeftover;
				sortTwoSortedArrays(indexLeftover, end);
			}
			
			
			insize = insize*2;
			if(insize>=size){
				exit=true;
				merge(start, (insize/2)-1, end);
			}
		}
		
		
	}
	
	private void sortTwoSortedArrays(int start, int end) {
		if(start==end)
			return;
		if(start==end-1){
			if(comp.compare(eu[start], eu[end])>0){
				Sort.swap(eu, start, end);
			}
			return;
		}
		
		int mid = (start+end)/2;
		merge(start, mid, end);
	}

	private void mergesort(int start, int end) {
		if(start==end)
			return;
		if(start==end-1){
			if(comp.compare(eu[start], eu[end])>0){
				Sort.swap(eu, start, end);
			}
			return;
		}
		int mid = (start+end)/2;
		mergesort(start, mid);
		mergesort(mid+1, end);
		merge(start, mid, end);
	}

	private void merge(int start, int mid, int end) {
		int ptr1 = start;
		int ptr2 = mid+1;
		int size = end+1-start;
		@SuppressWarnings("unchecked")
		T[] tempa = (T[])new Object[size];
		int i = 0;
		
		while(ptr1<=mid && ptr2<=end){
			if(comp.compare(eu[ptr1], eu[ptr2])<=0)
				tempa[i++] = eu[ptr1++];
			else
				tempa[i++] = eu[ptr2++];
		}
		
		//leftovers
		while(ptr1<=mid)
			tempa[i++] = eu[ptr1++];
		while(ptr2<=end)
			tempa[i++] = eu[ptr2++];
		
		//copyback
		while(--i>=0){
			eu[start+i] = tempa[i];
		}
		
	}
	
	private void merge2(int start, int mid, int end) {
		
		int size1 = mid-start+1;
		int size2 = end-mid;
		@SuppressWarnings("unchecked")
		T[] tempa = (T[])new Object[size1+size2];
		
		int i=0;
		int ptr1 = start;
		int ptr2 = mid+1;
		while((ptr1-start)<size1 && (ptr2-mid-1)<size2){
			if(comp.compare(eu[ptr1], eu[ptr2])>0)
				tempa[i++] = eu[ptr2++];
			else
				tempa[i++] = eu[ptr1++];
		}
		
		//leftovers
		while((ptr1-start)<size1)
			tempa[i++] = eu[ptr1++];
		while((ptr2-mid-1)<size2)
			tempa[i++] = eu[ptr2++];
		
		
		//Copy back merged array
		for(int j=0; j<i; j++){
			eu[start+j] = tempa[j];
		}
		
	}

}
