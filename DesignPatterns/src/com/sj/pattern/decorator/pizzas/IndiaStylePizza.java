package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public class IndiaStylePizza extends DecoratorPizza {

	public IndiaStylePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	protected void setCost(int cost) {
		this.cost = cost + 5;
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
	public void setName(String name) {
		this.name = "Indian style " + name;
	}

	@Override
	public void setDough(String dough) {
		this.dough = "Thick crust dough";
	}

	@Override
	public void setSauce(String sauce) {
		this.sauce = "Kissan tomato Sauce";
	}
	
	@Override
	public void setToppings(List<String> toppings) {

		if(toppings==null || toppings.isEmpty())
			return;
		
		this.toppings = new ArrayList<>(toppings.size());
		for(String topping:toppings) {
			this.toppings.add("Indian style "+topping);
		}
	}
}
