package com.sj.pattern.decorator.pizzas;

import java.util.Arrays;

import com.sj.pattern.factory.pizzas.ingredients.PizzaIngredientFactory;

public abstract class DecoratorPizza extends Pizza {

	protected Pizza pizza;
	protected PizzaIngredientFactory ingredientFactory;
	
	public DecoratorPizza(Pizza pizza, PizzaIngredientFactory ingredientFactory) {
		this.pizza = pizza;
		this.ingredientFactory = ingredientFactory;
		setCost(pizza.cost);
		setName(pizza.name);
		setDescription();
	}
	
	protected abstract void setCost(int cost);
	abstract void setName(String name);
	protected void setDescription() {
		this.description = "This is a "+name+".";
	}
	
	protected void setDough() {
		pizza.dough = ingredientFactory.createDough();
		this.dough = pizza.dough;
		
	}

	protected void setSauce() {
		pizza.sauce = ingredientFactory.createSauce();
		this.sauce = pizza.sauce;
	}

	protected void setToppings() {
		pizza.toppings = Arrays.asList(ingredientFactory.createVeggies());
		this.toppings = pizza.toppings;
	}
	
	@Override
	protected void prepareIngredients() {
		setDough();
		setSauce();
		setToppings();
	}
}
