package com.sj.pattern.decorator.pizzas;

public class MainPizzaStore {

	public static void main(String[] args) {
		createPizza(new ClassicPizza());
		createPizza(new CheesePizza());
		
		createPizza(new NYStylePizza(new CheesePizza()));
		
		createPizza(new IndiaStylePizza(new ClassicPizza()));
		
		createPizza(new LNStylePizza(new CheesePizza()));
		
		createPizza(new LNStylePizza(new NYStylePizza(new CheesePizza())));
		
		createPizza(new IndiaStylePizza(new VeggiePizza()));
		
	}

	private static void createPizza(Pizza pizza) {
		System.out.println(pizza.name +" - "+ pizza.description);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		System.out.println(pizza.name +" - "+ pizza.cost);
	}
}
