package com.sj.pattern.decorator.pizzas;

public class IndiaStylePizza extends DecoratorPizza {
	private IPizza pizza;
	
	public IndiaStylePizza(IPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return pizza.cost() + 5;
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
		System.out.println("Boxed in Indian Pizza Box");
	}

	@Override
	public String description() {
		return ("This is a "+name()+" pizza.");
	}

	@Override
	public String name() {
		return "Indian style " + pizza.name();
	}

}
