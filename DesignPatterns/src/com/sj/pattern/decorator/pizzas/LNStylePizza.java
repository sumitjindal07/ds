package com.sj.pattern.decorator.pizzas;

import com.sj.pattern.factory.pizzas.ingredients.LNPizzaIngredientFactory;

public class LNStylePizza extends DecoratorPizza {
	
	public LNStylePizza(Pizza pizza) {
		super(pizza, new LNPizzaIngredientFactory());
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
}
