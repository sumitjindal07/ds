package com.sj.pattern.factory.pizzas;

import com.sj.pattern.decorator.pizzas.CheesePizza;
import com.sj.pattern.decorator.pizzas.ClassicPizza;
import com.sj.pattern.decorator.pizzas.Pizza;
import com.sj.pattern.decorator.pizzas.VeggiePizza;
import com.sj.pattern.factory.pizzas.ingredients.IndiaPizzaIngredientFactory;
import com.sj.pattern.factory.pizzas.ingredients.PizzaIngredientFactory;

public class IndianPizzaStore extends PizzaStore {

	PizzaIngredientFactory ingredientFactory = new IndiaPizzaIngredientFactory();
	
	@Override
	protected Pizza createPizza(String type) {
		switch(type) {
		case "cheese":
			return new CheesePizza(ingredientFactory);
		case "classic":
			return new ClassicPizza(ingredientFactory);
		case "veggie":
			return new VeggiePizza(ingredientFactory);
		}
		return null;
	}

}
