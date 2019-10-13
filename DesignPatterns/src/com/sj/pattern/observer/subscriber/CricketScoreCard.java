package com.sj.pattern.observer.subscriber;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sj.pattern.observer.beans.ScoreBean;
import com.sj.pattern.observer.publisher.Subject;

public class CricketScoreCard implements Observer<ScoreBean>
{
	private Map<String, PlayerCard> playerCards = new LinkedHashMap<>();
	
	public CricketScoreCard(Subject<ScoreBean> subject, List<String> playerNames) {
		subject.registerObserver(this);
		
		for(String playerName:playerNames){
			playerCards.put(playerName, new PlayerCard(playerName));
		}
	}

	public void updateScoreCard(ScoreBean score) {
		PlayerCard playerCard = playerCards.get(score.getPlayerName());
		if(playerCard!=null) {
			if(score.isOut())
				playerCard.setOut();
			else
				playerCard.addRun(score.getRunsScoredByPlayer());
		}
	}

	@Override
	public void update(ScoreBean score) {
		updateScoreCard(score);
	}
	
	public void displayScoreCard() {
		int i=1;
		for(String playerName:playerCards.keySet()) {
			PlayerCard playerCard = playerCards.get(playerName);
			System.out.println((i++)+")"+(playerCard.playerName)+"\t"+(playerCard.isOut?"Out\t":"Not Out\t")+(playerCard.run));
		}
	}
	
	private class PlayerCard{
		private String playerName;
		private int run;
		private boolean isOut;
		
		public PlayerCard(String playerName) {
			this.playerName = playerName;
			this.run = 0;
			this.isOut = false;
		}
		
		private void addRun(int run) {
			this.run += run;
		}
		
		private void setOut() {
			isOut = true;
		}
	}
	
}
