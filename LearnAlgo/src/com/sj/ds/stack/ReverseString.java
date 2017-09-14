package com.sj.ds.stack;

import org.junit.Assert;

public class ReverseString {

	public static void main(String[] args) {
		
		String s = "ABCDEFGHIJ";
		
		String rev = reverse(s);
		System.out.println("Reverse of:\n"+s+":\n"+rev);
		
		Assert.assertTrue(rev.intern()==new StringBuffer(s).reverse().toString().intern());
	}

	private static String reverse(String s) {
		CharStack cs = new CharStack(s.length());
		
		for(char c : s.toCharArray())
			cs.push(c);
		
		/*for(char c1: cs){
			System.out.println(c1);
			if(c1=='D')
				cs.pop();
		}*/
		StringBuilder sb = new  StringBuilder();
		
		while(!cs.isEmpty())
			sb.append(cs.pop());
			
		return sb.toString();
	}
}
