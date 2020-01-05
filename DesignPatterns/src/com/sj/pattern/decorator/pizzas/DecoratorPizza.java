package com.sj.pattern.decorator.pizzas;

public abstract class DecoratorPizza implements IPizza {
	@Override
	public abstract String description();
	
	@Override
	public abstract String name();
}
