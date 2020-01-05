package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

	protected int cost;
	
	protected String name = "Pizza";
	
	protected String dough= "Pizza dough";
	
	protected String sauce = "Pizza sauce";
	
	protected String description= "This is a Pizza";
	
	protected void setCost(int cost) {
		this.cost = cost;
	}
	
	public abstract void bake();
	public abstract void cut();
	public abstract void box();
	
	protected List<String> toppings = new ArrayList<String>();
	
	public List<String> getToppings() {
		return toppings;
	}
	
	final public void prepare() {
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough -"+dough+"...");
		System.out.println("Adding sauce -"+sauce+"...");
		
		if(toppings!=null && toppings.size()>0) {
			System.out.println("Adding toppings: ");
			for(String topping:toppings) {
				System.out.println(" " + topping);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
}
