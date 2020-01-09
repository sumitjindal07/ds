package com.sj.pattern.factory.pizzas.ingredients;

public class LNPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return Dough.ThickCrustDough;
	}

	@Override
	public Sauce createSauce() {
		return Sauce.PlumTomatoSauce;
	}

	@Override
	public Cheese createCheese() {
		return Cheese.MozarellaCheese;
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = {Veggies.BlackOlives, Veggies.Spinach, Veggies.EggPlant};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return Pepperoni.SlicedPepperoni;
	}

	@Override
	public Clams createClams() {
		return Clams.FrozenClams;
	}

}
