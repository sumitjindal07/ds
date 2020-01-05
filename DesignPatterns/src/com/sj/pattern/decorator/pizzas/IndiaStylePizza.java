package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public class IndiaStylePizza extends DecoratorPizza {
	private IPizza pizza;
	
	private List<String> toppings = null;
	
	public IndiaStylePizza(IPizza pizza) {
		this.pizza = pizza;
		initToppings(pizza.getToppings());
	}

	private void initToppings(List<String> toppings) {
		if(toppings==null || toppings.isEmpty())
			return;
		
		this.toppings = new ArrayList<>(toppings.size());
		for(String topping:toppings) {
			this.toppings.add("Indian style "+topping);
		}
	}

	@Override
	public int cost() {
		return pizza.cost() + 5;
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
		System.out.println("Boxed in Indian Pizza Box");
	}

	@Override
	public String description() {
		return ("This is a "+name()+" pizza.");
	}

	@Override
	public String name() {
		return "Indian style " + pizza.name();
	}

	@Override
	public List<String> getToppings() {
		return toppings;
	}

	@Override
	public String dough() {
		return "Thick crust dough";
	}

	@Override
	public String sauce() {
		return "Kissan tomato Sauce";
	}
}
