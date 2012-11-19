package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * this class represents a pokemon
 * @author Team Rocket
 * @version 1.0
 */
public abstract class Pokemon extends Item implements Usable {

	/**
	 * Field strengthBoost.
	 */
	private int strengthBoost;
	
	/**
	 * Field tradeBoost.
	 */
	private int tradeBoost;
	
	/**
	 * Field staminaBoost.
	 */
	private int staminaBoost;
	
	/**
	 * Field agilityBoost.
	 */
	private int agilityBoost;

	/**
	 * Pokemon Constructor
	 * 
	 * @param strength
	 * @param trade
	 * @param stamina
	 * @param agility
	 */
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
