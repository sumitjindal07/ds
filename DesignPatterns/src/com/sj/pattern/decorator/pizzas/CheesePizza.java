package com.sj.pattern.decorator.pizzas;

import java.util.Arrays;

import com.sj.pattern.factory.pizzas.ingredients.Cheese;
import com.sj.pattern.factory.pizzas.ingredients.Dough;
import com.sj.pattern.factory.pizzas.ingredients.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
	
	public CheesePizza() {
		setCost(2);
		name = "Cheese Pizza";
		dough = Dough.PizzaDough;
		cheese = Cheese.PizzaCheese;
	}

	PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this();
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public void bake() {
		System.out.println("Baked for 15 mins");
	}

	@Override
	public void cut() {
		System.out.println("Cut in Triangular Slices");
	}

	@Override
	public void box() {
		System.out.println("Boxed in Pizza Box");
	}

	@Override
	protected void prepareIngredients() {
		if(ingredientFactory!=null) {
			dough = ingredientFactory.createDough();
			sauce = ingredientFactory.createSauce();
			cheese = ingredientFactory.createCheese();
			toppings.addAll(Arrays.asList(ingredientFactory.createVeggies()));
		}
	}
}
