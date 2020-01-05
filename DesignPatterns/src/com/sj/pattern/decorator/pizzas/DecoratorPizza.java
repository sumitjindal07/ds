package com.sj.pattern.decorator.pizzas;

import java.util.List;

public abstract class DecoratorPizza implements IPizza {
	@Override
	public abstract String description();
	@Override
	public abstract String dough();
	@Override
	public abstract String sauce();
	@Override
	public abstract List<String> getToppings();
}
