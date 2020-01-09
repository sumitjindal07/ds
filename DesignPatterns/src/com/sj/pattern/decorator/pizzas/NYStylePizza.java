package com.sj.pattern.decorator.pizzas;

import com.sj.pattern.factory.pizzas.ingredients.NYPizzaIngredientFactory;

public class NYStylePizza extends DecoratorPizza {
	
	public NYStylePizza(Pizza pizza) {
		super(pizza, new NYPizzaIngredientFactory());
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
}
