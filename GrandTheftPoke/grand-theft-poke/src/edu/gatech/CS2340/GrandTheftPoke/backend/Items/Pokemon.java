package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public abstract class Pokemon extends Item implements Usable {

	private int strengthBoost;
	private int tradeBoost;
	private int staminaBoost;
	private int agilityBoost;

	public Pokemon(int strength, int trade, int stamina, int agility) {
		strengthBoost = strength;
		tradeBoost = trade;
		staminaBoost = stamina;
		agilityBoost = agility;
	}

	@Override
	public void use(Person person) {
		person.setStrength(strengthBoost);
		person.setAgility(agilityBoost);
		person.setStamina(staminaBoost);
		person.setTrade(tradeBoost);
	}

	@Override
	public void unUse(Person person) {
		person.setStrength(-strengthBoost);
		person.setAgility(-agilityBoost);
		person.setStamina(-staminaBoost);
		person.setTrade(-tradeBoost);
	}
}
