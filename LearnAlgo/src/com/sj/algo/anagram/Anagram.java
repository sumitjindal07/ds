package com.sj.algo.anagram;

public class Anagram {

	public static void anagram(String word, int start){
		//System.out.println("start="+start);
		if(start==word.length()-1)
			return;
		
		for(int i=start; i<word.length(); i++){
			anagram(word, start+1);
			if(start==word.length()-2)
				System.out.println("Display word:"+word);
			
			//Rotate
			word = word.substring(0,start)+word.substring(start+1)+word.charAt(start);
			//System.out.println("Rotated:"+word);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		anagram("abcdefghij",0);

	}

}
