package com.sj.pattern.decorator.pizzas;

import com.sj.pattern.factory.pizzas.ingredients.IndiaPizzaIngredientFactory;

public class IndiaStylePizza extends DecoratorPizza {

	public IndiaStylePizza(Pizza pizza) {
		super(pizza, new IndiaPizzaIngredientFactory());
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
}
