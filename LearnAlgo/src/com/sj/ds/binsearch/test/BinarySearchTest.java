package com.sj.ds.binsearch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sj.ds.binsearch.BinarySearch;

public class BinarySearchTest {

	@Test
	public void testFind() {
		Integer[] arr = {1,3,5,7,9,11,13,15,17,19};
		assertTrue(BinarySearch.find(arr, 3)==1);
		assertTrue(BinarySearch.find(arr, 18)==-1);
	}

	@Test
	public void testFindInsertPos() {
		Integer[] arr = {1,3,5,7,9,11,13,15,17,19};
		assertTrue(BinarySearch.findInsertPos(arr, 3)==1);
		assertTrue(BinarySearch.findInsertPos(arr, 4)==2);
		assertTrue(BinarySearch.findInsertPos(arr, 20)==10);
		assertTrue(BinarySearch.findInsertPos(arr, 0)==0);
		assertTrue(BinarySearch.findInsertPos(arr, 1)==0);
		assertTrue(BinarySearch.findInsertPos(arr, 21)==10);
		assertTrue(BinarySearch.findInsertPos(arr, 11)==5);
		
		Integer[] arr1 = {1};
		assertTrue(BinarySearch.findInsertPos(arr1, 3)==1);
		assertTrue(BinarySearch.findInsertPos(arr1, 0)==0);
		assertTrue(BinarySearch.findInsertPos(arr1, 1)==0);
		
		Integer[] arr2 = {1,3};
		assertTrue(BinarySearch.findInsertPos(arr2, 3)==2);
		assertTrue(BinarySearch.findInsertPos(arr2, 0)==0);
		assertTrue(BinarySearch.findInsertPos(arr2, 1)==0);
		
	}

}
