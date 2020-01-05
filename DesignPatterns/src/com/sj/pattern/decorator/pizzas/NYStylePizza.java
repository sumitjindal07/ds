package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public class NYStylePizza extends DecoratorPizza {
	
	public NYStylePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	protected void setCost(int cost) {
		this.cost = cost + 10;
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
	public void setName(String name) {
		this.name = "NY style " + name;
	}

	@Override
	public void setDough(String dough) {
		this.dough = "Thin crust dough";
	}

	@Override
	public void setSauce(String sauce) {
		this.sauce = "Marinara Sauce";
	}

	@Override
	public void setToppings(List<String> toppings) {

		if(toppings==null || toppings.isEmpty())
			return;
		
		this.toppings = new ArrayList<>(toppings.size());
		for(String topping:toppings) {
			this.toppings.add("NY style "+topping);
		}
	}
}
