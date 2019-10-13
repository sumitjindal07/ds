package com.sj.pattern.observer.publisher;

import java.util.Set;

import com.sj.pattern.observer.subscriber.Observer;

public  interface Subject<T>
{
    public Set<Observer<T>> getObservers();

	public default void notifyObservers(T t) {
		for(Observer<T> observer:getObservers()) {
			observer.update(t);
		}
	}

	public default boolean registerObserver(Observer<T> observer) {
		return getObservers().add(observer);
	}

	public default boolean removeObserver(Observer<T> observer) {
		return getObservers().remove(observer);
	}
}

