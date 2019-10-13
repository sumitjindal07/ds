package com.sj.pattern.observer.subscriber;

import com.sj.pattern.observer.beans.ScoreBean;
import com.sj.pattern.observer.publisher.CricketScoreFeed;
import com.sj.pattern.observer.publisher.Subject;

public class CommentaryUpdate implements Observer<ScoreBean>
{
	private static boolean isStarted;
	
	private CommentaryUpdate(Subject<ScoreBean> subject) {
		subject.registerObserver(this);
		isStarted = true;
	}
	
	public void addCommentaryForBall(ScoreBean score) {
		System.out.print("Commentary:"+score.getPlayerName());
		if(score.isOut())
			System.out.println(" is out!!");
		else
			System.out.println(" scored " + score.getRunsScoredByPlayer() + " runs");
	}

	@Override
	public void update(ScoreBean score) {
		addCommentaryForBall(score);
	}

	public static void start(CricketScoreFeed scoreFeed) {
		if(!isStarted)
			new CommentaryUpdate(scoreFeed);
	}
}
