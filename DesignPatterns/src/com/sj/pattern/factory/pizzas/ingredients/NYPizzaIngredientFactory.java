package com.sj.pattern.factory.pizzas.ingredients;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return Dough.ThinCrustDough;
	}

	@Override
	public Sauce createSauce() {
		return Sauce.MarinaraSauce;
	}

	@Override
	public Cheese createCheese() {
		return Cheese.ReggianoCheese;
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = {Veggies.Garlic, Veggies.Onion, Veggies.Mushroom, Veggies.Redpepper};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return Pepperoni.SlicedPepperoni;
	}

	@Override
	public Clams createClams() {
		return Clams.FreshClams;
	}

}
