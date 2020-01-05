package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public class LNStylePizza extends DecoratorPizza {
	
	public LNStylePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	protected void setCost(int cost) {
		this.cost = cost + 15;
	}
	
	@Override
	public void bake() {
		pizza.bake();
		System.out.println("Again bake");
		pizza.bake();
	}

	@Override
	public void cut() {
		System.out.println("Cut in Square Slices");
	}

	@Override
	public void box() {
		System.out.println("Boxed in LN Pizza Box");
	}

	@Override
	public void setName(String name) {
		this.name = "LN style " + name;
	}

	@Override
	public void setDough(String dough) {
		this.dough = "Extra Thick crust dough";
	}

	@Override
	public void setSauce(String sauce) {
		this.sauce = "Plum tomato Sauce";
	}

	@Override
	public void setToppings(List<String> toppings) {

		if(toppings==null || toppings.isEmpty())
			return;
		
		this.toppings = new ArrayList<>(toppings.size());
		for(String topping:toppings) {
			this.toppings.add("LN style "+topping);
		}
	}
}
