package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public class NYStylePizza extends DecoratorPizza {
	private IPizza pizza;
	
	private List<String> toppings = null;
	
	public NYStylePizza(IPizza pizza) {
		this.pizza = pizza;
		initToppings(pizza.getToppings());
	}

	private void initToppings(List<String> toppings) {
		if(toppings==null || toppings.isEmpty())
			return;
		
		this.toppings = new ArrayList<>(toppings.size());
		for(String topping:toppings) {
			this.toppings.add("NY style "+topping);
		}
	}

	@Override
	public int cost() {
		return pizza.cost() + 10;
	}

	@Override
	public void bake() {
		pizza.bake();
	}

	@Override
	public void cut() {
		pizza.cut();
	}

	@Override
	public void box() {
		System.out.println("Boxed in NY Pizza Box");
	}

	@Override
	public String description() {
		return ("This is a "+name()+" pizza.");
	}

	@Override
	public String name() {
		return "NY style " + pizza.name();
	}

	@Override
	public List<String> getToppings() {
		return toppings;
	}

	@Override
	public String dough() {
		return "Thin crust dough";
	}

	@Override
	public String sauce() {
		return "Marinara Sauce";
	}
}
