package com.sj.pattern.decorator.pizzas;

public class CheesePizza implements IPizza {

	@Override
	public int cost() {
		return 2;
	}

	@Override
	public String name() {
		return "Cheese";
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

}
