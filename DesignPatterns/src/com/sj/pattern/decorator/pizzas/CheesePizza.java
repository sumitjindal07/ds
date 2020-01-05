package com.sj.pattern.decorator.pizzas;

public class CheesePizza extends Pizza {

	public CheesePizza() {
		toppings.add("Cheese");
		setCost(2);
		name = "Cheese Pizza";
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
