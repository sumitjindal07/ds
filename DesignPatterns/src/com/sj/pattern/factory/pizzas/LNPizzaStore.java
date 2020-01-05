package com.sj.pattern.factory.pizzas;

import com.sj.pattern.decorator.pizzas.CheesePizza;
import com.sj.pattern.decorator.pizzas.ClassicPizza;
import com.sj.pattern.decorator.pizzas.LNStylePizza;
import com.sj.pattern.decorator.pizzas.Pizza;
import com.sj.pattern.decorator.pizzas.VeggiePizza;

public class LNPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		switch(type) {
		case "cheese":
			return new LNStylePizza(new CheesePizza());
		case "classic":
			return new LNStylePizza(new ClassicPizza());
		case "veggie":
			return new LNStylePizza(new VeggiePizza());
		}
		return null;
	}

}
