package com.sj.pattern.decorator.pizzas;

import java.util.Arrays;

import com.sj.pattern.factory.pizzas.ingredients.Dough;
import com.sj.pattern.factory.pizzas.ingredients.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;
	
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this();
		this.ingredientFactory = ingredientFactory;
	}
	
	public VeggiePizza() {
		setCost(5);
		name = "Veggie Pizza";
		dough = Dough.PizzaDough;
	}

	@Override
	public void bake() {
		System.out.println("Baked for 7 mins");
	}

	@Override
	public void cut() {
		System.out.println("Cut in Triangular Slices");
	}

	@Override
	public void box() {
		System.out.println("Boxed in Pizza packet");
	}
	
	@Override
	protected void prepareIngredients() {
		if(ingredientFactory!=null) {
			dough = ingredientFactory.createDough();
			sauce = ingredientFactory.createSauce();
			toppings.addAll(Arrays.asList(ingredientFactory.createVeggies()));
		}
	}
}
