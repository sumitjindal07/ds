package com.sj.pattern.decorator.pizzas;

import java.util.ArrayList;
import java.util.List;

import com.sj.pattern.factory.pizzas.ingredients.Cheese;
import com.sj.pattern.factory.pizzas.ingredients.Clams;
import com.sj.pattern.factory.pizzas.ingredients.Dough;
import com.sj.pattern.factory.pizzas.ingredients.Pepperoni;
import com.sj.pattern.factory.pizzas.ingredients.Sauce;
import com.sj.pattern.factory.pizzas.ingredients.Veggies;

public abstract class Pizza {

	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clams;
	
	protected List<Veggies> toppings = new ArrayList<Veggies>();
	
	protected String description = "This is a pizza";
	protected int cost;
	
	public abstract void bake();
	public abstract void cut();
	public abstract void box();
	
	public List<Veggies> getToppings() {
		return toppings;
	}
	
	final public void prepare() {
		System.out.println("Preparing "+name);
		prepareIngredients();
		System.out.println("Adding dough-"+dough);
		if(sauce!=null)
			System.out.println("Adding sauce-"+sauce);
		if(cheese!=null)
			System.out.println("Adding cheese-"+cheese);
		if(pepperoni!=null)
			System.out.println("Adding pepperoni-"+pepperoni);
		if(clams!=null)
			System.out.println("Adding clams-"+clams);
		if(toppings!=null && toppings.size()>0)
		{
			for (Veggies veggies : toppings) {
				System.out.println("Adding veggies-"+veggies);
			}
		}
	}
	
	protected abstract void prepareIngredients();

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	protected void setCost(int cost) {
		this.cost = cost;
	}
}
