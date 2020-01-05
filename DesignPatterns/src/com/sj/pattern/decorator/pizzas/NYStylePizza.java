package com.sj.pattern.decorator.pizzas;

public class NYStylePizza extends DecoratorPizza {
	private IPizza pizza;
	
	public NYStylePizza(IPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return pizza.cost() + 10;
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
		System.out.println("Boxed in NY Pizza Box");
	}

	@Override
	public String description() {
		return ("This is a "+name()+" pizza.");
	}

	@Override
	public String name() {
		return "NY style " + pizza.name();
	}

}
