package com.sj.pattern.observer.publisher;

import java.util.HashSet;
import java.util.Set;

import com.sj.pattern.observer.beans.ScoreBean;
import com.sj.pattern.observer.subscriber.Observer;

//TODO: read STATE pattern and change this
public class CricketScoreFeed implements Subject<ScoreBean>
{
	private Set<Observer<ScoreBean>> observers = new HashSet<>();
	
	@Override
	public Set<Observer<ScoreBean>> getObservers() {
		return observers;
	}

	public void newScore(String playerName, int runScored, boolean isOut) {
		notifyObservers(new ScoreBean(playerName, runScored, isOut));
	}
}
