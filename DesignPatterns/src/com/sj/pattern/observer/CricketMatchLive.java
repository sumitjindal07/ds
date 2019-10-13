package com.sj.pattern.observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sj.pattern.observer.publisher.CricketScoreFeed;
import com.sj.pattern.observer.subscriber.CommentaryUpdate;
import com.sj.pattern.observer.subscriber.CricketScoreCard;

public class CricketMatchLive {

	private CricketScoreFeed scoreFeed;
	private CricketScoreCard scoreCard;
	private List<String> playerNames;
	
	public static void main(String[] args) {
		CricketMatchLive liveMatch = new CricketMatchLive();
		liveMatch.init();
		liveMatch.start();
		liveMatch.end();
	}

	private void end() {
		System.out.println("\nMatch inning is Over!!");
		scoreCard.displayScoreCard();
	}

	private void start() {
		System.out.println("Match has started!!");
		scoreCard.displayScoreCard();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Iterator<String> players = playerNames.iterator();
		String player = players.next();
		while(true) {
			String ballScore = getBallScore(reader);

			if(ballScore.equals("out")) {
				scoreFeed.newScore(player, 0, true);
				if(players.hasNext())
					player = players.next();
				else
					break;
			}
			else if(ballScore.equals("exit")) {
				break;
			}else {
				scoreFeed.newScore(player, getValidRun(ballScore), false);
			}
		}
	}

	private int getValidRun(String ballScore) {
		try {
			int run = Integer.parseInt(ballScore);
			if(run<0 || run>7)
				System.out.println("Invalid run");
			else
				return run;
		}catch(Exception e) {
			System.out.println("Invalid input");
		}
		return 0;
	}

	private String getBallScore(BufferedReader reader) {
		try {
			return reader.readLine().trim().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private void init() {
		
		playerNames = Arrays.asList("Sachin", "Sehwag", "Dravid", 
									"Ganguly", "Dhoni ", "Kohli ", 
									"RohitSharma", "Jadeja", "Bumrah", 
									"Shami", "Ashwin");
		scoreFeed = new CricketScoreFeed();
		scoreCard = new CricketScoreCard(scoreFeed, playerNames);
		CommentaryUpdate.start(scoreFeed);
	}

}
