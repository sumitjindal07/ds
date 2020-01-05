package com.sj.pattern.factory.pizzas;

import com.sj.pattern.decorator.pizzas.CheesePizza;
import com.sj.pattern.decorator.pizzas.ClassicPizza;
import com.sj.pattern.decorator.pizzas.IndiaStylePizza;
import com.sj.pattern.decorator.pizzas.Pizza;
import com.sj.pattern.decorator.pizzas.VeggiePizza;

public class IndianPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		switch(type) {
		case "cheese":
			return new IndiaStylePizza(new CheesePizza());
		case "classic":
			return new IndiaStylePizza(new ClassicPizza());
		case "veggie":
			return new IndiaStylePizza(new VeggiePizza());
		}
		return null;
	}

}
