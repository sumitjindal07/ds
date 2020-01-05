package com.sj.pattern.factory.pizzas;

import com.sj.pattern.decorator.pizzas.Pizza;

public class PizzaFactoryMain {
	
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore lnStore = new LNPizzaStore();
		PizzaStore indianStore = new IndianPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("C1 ordered a "+pizza.getName()+" with price="+pizza.getCost());
		
		pizza = lnStore.orderPizza("veggie");
		System.out.println("C2 ordered a "+pizza.getName()+" with price="+pizza.getCost());
		
		pizza = lnStore.orderPizza("classic");
		System.out.println("C3 ordered a "+pizza.getName()+" with price="+pizza.getCost());
		
		pizza = indianStore.orderPizza("veggie");
		System.out.println("C4 ordered a "+pizza.getName()+" with price="+pizza.getCost());
	}
	
}
