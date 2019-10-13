package com.sj.pattern.observer.beans;

public class ScoreBean {
	private String playerName;
	private int runsScoredByPlayer;
	private boolean isOut;
	
	public ScoreBean(String playerName, int runsScoredByPlayer, boolean isOut) {
		this.playerName = playerName;
		this.runsScoredByPlayer = runsScoredByPlayer;
		this.isOut = isOut;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getRunsScoredByPlayer() {
		return runsScoredByPlayer;
	}

	public boolean isOut() {
		return isOut;
	}
}
