package com.sj.pattern.decorator.pizzas;

public class MainPizzaStore {

	public static void main(String[] args) {
		createPizza(new ClassicPizza());
		createPizza(new CheesePizza());
		
		createPizza(new NYStylePizza(new CheesePizza()));
		
		createPizza(new IndiaStylePizza(new ClassicPizza()));
		
	}

	private static void createPizza(IPizza pizza) {
		System.out.println(pizza.name() +" - "+ pizza.description());
		pizza.bake();
		pizza.cut();
		pizza.box();
		System.out.println(pizza.name() +" - "+ pizza.cost());
	}
}
