package com.sj.pattern.factory.pizzas.ingredients;

public class IndiaPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return Dough.VeryThinCrustDough;
	}

	@Override
	public Sauce createSauce() {
		return Sauce.PlumTomatoSauce;
	}

	@Override
	public Cheese createCheese() {
		return Cheese.GoatCheese;
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = {Veggies.BlackOlives, Veggies.Onion, Veggies.Spinach, Veggies.Redpepper};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return Pepperoni.PizzaPepperoni;
	}

	@Override
	public Clams createClams() {
		return Clams.PizzaClams;
	}

}
