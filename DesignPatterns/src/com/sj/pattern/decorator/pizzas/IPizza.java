package com.sj.pattern.decorator.pizzas;

public interface IPizza {

	int cost();
	String name();
	default String description() {
		return "This is a Pizza";
	}
	
	void bake();
	void cut();
	void box();
}
