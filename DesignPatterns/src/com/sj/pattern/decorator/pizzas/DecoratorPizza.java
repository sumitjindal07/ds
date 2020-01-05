package com.sj.pattern.decorator.pizzas;

import java.util.List;

public abstract class DecoratorPizza extends Pizza {

	protected Pizza pizza;
	
	public DecoratorPizza(Pizza pizza) {
		this.pizza = pizza;
		setCost(pizza.cost);
		setName(pizza.name);
		setDough(pizza.dough);
		setSauce(pizza.sauce);
		setDescription(pizza.description);
		setToppings(pizza.toppings);
	}
	
	protected abstract void setCost(int cost);
	abstract void setName(String name);
	abstract void setDough(String dough);
	abstract void setSauce(String sauce);
	abstract void setToppings(List<String> toppings);
	
	protected void setDescription(String description) {
		this.description = "This is a "+name+".";
	}
}
