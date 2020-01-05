package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheesePizza implements IPizza {

	private List<String> toppings = new ArrayList<String>(Arrays.asList("Cheese"));
	
	@Override
	public int cost() {
		return 2;
	}

	@Override
	public String name() {
		return "Cheese Pizza";
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
	
	@Override
	public List<String> getToppings() {
		return toppings;
	}
}
