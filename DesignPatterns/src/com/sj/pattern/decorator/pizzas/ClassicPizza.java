package com.sj.pattern.decorator.pizzas;

public class ClassicPizza implements IPizza {

	@Override
	public int cost() {
		return 1;
	}

	@Override
	public String name() {
		return "Classic";
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
