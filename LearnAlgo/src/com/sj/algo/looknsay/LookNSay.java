package com.sj.algo.looknsay;

public class LookNSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =20;
		String term = findNthTerm(n);
		System.out.println(term);
		
	}

	private static String findNthTerm(int n) {
		String nthTerm = "1";
		int i = 1;
		for(; i<=n; i++){
			String readTerm = getTerm(nthTerm);
			nthTerm = readTerm;
		}
		return nthTerm;
	}

	private static String getTerm(String nthTerm) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<nthTerm.length(); i++){
			int ct=1;
			char c = nthTerm.charAt(i);
			for(int j=i+1; j<nthTerm.length(); j++){
				if(c==nthTerm.charAt(j)){
					ct++;
					i=j;
				}else
					break;
			}
			sb.append(ct).append(c);
		}
		System.out.println(sb);
		return sb.toString();
	}

}
