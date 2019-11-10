package com.sj.pattern.observer.subscriber;

import com.sj.pattern.observer.beans.ScoreBean;
import com.sj.pattern.observer.publisher.CricketScoreFeed;
import com.sj.pattern.observer.publisher.Subject;

public class BreakChecker implements Observer<ScoreBean>
{
	private static boolean isStarted;
	private static int ballCount;
	
	private BreakChecker(Subject<ScoreBean> subject) {
		subject.registerObserver(this);
		isStarted = true;
	}
	
	public void checkIfTimeForBreak(ScoreBean score) {
		ballCount++;
		if(ballCount==6){
			//this doesn't check for no balls.. wide balls currently
			ballCount = 0;
			System.out.println("Time For break as Over"+(score.isOut()?" and Out":"")+"!!");
		}else if(score.isOut())
			System.out.println("Time For break as Out!!");
	}

	@Override
	public void update(ScoreBean score) {
		checkIfTimeForBreak(score);
	}

	public static void start(CricketScoreFeed scoreFeed) {
		if(!isStarted)
			new BreakChecker(scoreFeed);
	}
}
