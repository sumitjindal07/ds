package com.sj.pattern.decorator.pizzas;

public class ClassicPizza extends Pizza {

	public ClassicPizza() {
		setCost(1);
		name = "Classic Pizza";
	}
	
	@Override
	public void bake() {
		System.out.println("Baked for 10 mins");
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
