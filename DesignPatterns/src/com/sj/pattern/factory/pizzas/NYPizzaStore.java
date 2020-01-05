package com.sj.pattern.factory.pizzas;

import com.sj.pattern.decorator.pizzas.CheesePizza;
import com.sj.pattern.decorator.pizzas.ClassicPizza;
import com.sj.pattern.decorator.pizzas.Pizza;
import com.sj.pattern.decorator.pizzas.VeggiePizza;
import com.sj.pattern.decorator.pizzas.NYStylePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		switch(type) {
		case "cheese":
			return new NYStylePizza(new CheesePizza());
		case "classic":
			return new NYStylePizza(new ClassicPizza());
		case "veggie":
			return new NYStylePizza(new VeggiePizza());
		}
		return null;
	}

}
