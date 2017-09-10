package com.sj.algo.combination;

public class PickATeam {

	
	static char[] chars = {'A','B','C','D','E'};
	
	
	public static void main(String[] args) {
			
		int total = chars.length;
		int req =3;
		
		pickATeam(0, req, total, "");
	}


	private static void pickATeam(int index, int req, int total, String team) {

		if(req==0){
			System.out.println(team);
			return;
		}
		if(req==total){
			System.out.println(team+new String(chars).substring(index));
			return;
		}
		
		pickATeam(index+1, req-1, total-1, team+chars[index]);
		
		pickATeam(index+1, req, total-1, team);
	}

}
