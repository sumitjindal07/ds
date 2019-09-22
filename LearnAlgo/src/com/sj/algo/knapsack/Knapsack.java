package com.sj.algo.knapsack;

import java.util.ArrayList;
import java.util.List;
//test
public class Knapsack {

	static int[] wts = {11, 8, 7, 6 , 5};
	static List<Integer> res = new ArrayList<>();
	
	public static void main(String[] args) {
		
		boolean done = knapsack(37, 0);
		System.out.println(done?res:"No valid comb");
		
	}

	private static boolean knapsack(int req, int index) 
	{
		if(index==wts.length)
			return false;
		if(wts[index]==req){
			res.add(wts[index]);
			return true;
		}
		if(wts[index]<req){
			boolean done = knapsack(req-wts[index], index+1);
			if(done){
				res.add(wts[index]);
				return true;
			}
		}
		return knapsack(req, index+1);
	}
}
