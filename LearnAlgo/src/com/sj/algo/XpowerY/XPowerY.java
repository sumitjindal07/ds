package com.sj.algo.XpowerY;

import java.util.Stack;

public class XPowerY {

	public static void main(String[] args) {
		int x = 3;
		int y = 18;
		long res = power(x,y);
		System.out.println(x+" to the power "+y+" = "+res);
		
		res = powerWithRec(x,y);
		System.out.println(x+" to the powerWithRec "+y+" = "+res);

	}

	private static long powerWithRec(int x, int y) {
		System.out.println("Entering with x="+x+", y="+y);
		if(y==1)
			return x;
		long ans = powerWithRec(x*x, y/2);
		System.out.println("ans="+ans);
		if(y%2==1)
			ans = ans*x;
		return ans;
	}

	private static long power(int x, int y) {
		Stack<Integer> xStk = new Stack<>();
		Stack<Integer> yStk = new Stack<>();
		
		long ans = 1;
		while(y!=0){
			xStk.push(x);	
			x=x*x;
			yStk.push(y);	
			y=y/2;
			System.out.println("Pushed "+xStk.peek()+", "+yStk.peek()+" in stack");			
		}
		
		ans = xStk.pop();
		yStk.pop();
		while(!yStk.isEmpty()){
			x = xStk.pop();
			y = yStk.pop();
			if(y%2==1)
				ans = ans*x;
		}
		return ans;
	}
	
	

}
