package com.sj.algo.hanoi;

public class TowerOfHanoi {

	static int step=0;
		public static void main(String[] args) {
			tower(64,'s','i','d');
		}

		private static void tower(int n, char s, char i, char d) {
			if(n==1){
				System.out.println((++step)+":Move Disk#"+n+" from "+s+" to "+d);
				return;
			}
			
			tower(n-1, s, d, i);
			System.out.println((++step)+":Move Disk#"+n+" from "+s+" to "+d);
			tower(n-1, i, s, d);
		}
}
