package com.sj.ds.binsearch;

public class BinarySearch {

	public static <T extends Comparable<T>> int find(final T[] arr, final T elem){
		return recFind(0, arr.length-1, arr, elem);
	}
	
	private static <T extends Comparable<T>> int recFind(int a, int z, final T[] arr, final T elem) {
		if(a>z)
			return -1;
		
		int mid = (a+z)/2;
		if(arr[mid].compareTo(elem)==0)
			return mid;
		if(arr[mid].compareTo(elem)>0)
			return recFind(a, mid-1, arr, elem);
		else
			return recFind(mid+1, z, arr, elem);
	}
	
	public static <T extends Comparable<T>> int findInsertPos(int head, final T[] arr, final T elem){
		return recFindInsertPos(0, head, arr, elem);
	}
	
	public static <T extends Comparable<T>> int findInsertPos(final T[] arr, final T elem){
		return findInsertPos(arr.length-1, arr, elem);
	}
	
	private static <T extends Comparable<T>> int recFindInsertPos(int a, int z, final T[] arr, final T elem) {
		if(a>z)
			return -1;
		
		if(arr[a].compareTo(elem)>=0)
			return a;
		if(arr[z].compareTo(elem)<=0)
			return z+1;
					
		int mid = (a+z)/2;
		if(arr[mid].compareTo(elem)==0)
			return mid;
		if(arr[mid].compareTo(elem)>0){
			if(mid>a && arr[mid-1].compareTo(elem)<=0)
				return mid;
			else
				return recFindInsertPos(a, mid-1, arr, elem);
		}else{
			if(mid<z && arr[mid+1].compareTo(elem)>=0)
				return mid+1;
			else
				return recFind(mid+1, z, arr, elem);
		}
	}
	
}
