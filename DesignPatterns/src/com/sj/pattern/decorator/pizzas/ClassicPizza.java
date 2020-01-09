package com.sj.pattern.decorator.pizzas;

import java.util.Arrays;

import com.sj.pattern.factory.pizzas.ingredients.Dough;
import com.sj.pattern.factory.pizzas.ingredients.PizzaIngredientFactory;

public class ClassicPizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;
	
	public ClassicPizza(PizzaIngredientFactory ingredientFactory) {
		this();
		this.ingredientFactory = ingredientFactory;
	}
	
	public ClassicPizza() {
		setCost(1);
		name = "Classic Pizza";
		dough = Dough.PizzaDough;
	}

	@Override
	public void bake() {
		System.out.println("Baked for 10 mins");
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
			toppings.addAll(Arrays.asList(ingredientFactory.createVeggies()));
		}
	}
}
