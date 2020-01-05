package com.sj.pattern.decorator.pizzas;

import java.util.List;

public interface IPizza {

	int cost();
	
	String name();
	
	default String dough() {
		return "Pizza dough";
	}
	
	default String sauce() {
		return "Pizza sauce";
	}
	
	default String description() {
		return "This is a Pizza";
	}
	
	void bake();
	void cut();
	void box();
	
	default List<String> getToppings() {
		return null;
	}
	
	default void prepare() {
		System.out.println("Preparing "+name());
		System.out.println("Tossing dough -"+dough()+"...");
		System.out.println("Adding sauce -"+sauce()+"...");
		
		List<String> toppings = getToppings();
		if(toppings!=null && toppings.size()>0) {
			System.out.println("Adding toppings: ");
			for(String topping:toppings) {
				System.out.println(" " + topping);
			}
		}
	}
}
