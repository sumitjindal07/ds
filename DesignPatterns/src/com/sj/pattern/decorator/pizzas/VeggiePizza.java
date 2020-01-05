package com.sj.pattern.decorator.pizzas;

public class VeggiePizza extends Pizza {

	public VeggiePizza() {
		toppings.add("Cucumber");
		toppings.add("Tomato");
		setCost(5);
		name = "Veggie Pizza";
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
}
