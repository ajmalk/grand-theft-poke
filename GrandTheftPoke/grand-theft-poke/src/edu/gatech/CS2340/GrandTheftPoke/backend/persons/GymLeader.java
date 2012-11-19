package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;

/**
 * The GymLeader
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class GymLeader extends Person {
	private int stake;

	/**
	 * @param name
	 * @param strength
	 * @param agility
	 * @param trade
	 * @param stamina
	 * @param health
	 * @param range
	 * @param capacity
	 * @param money
	 * @param theMap
	 */
	public GymLeader(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap) {
		super(name, strength, agility, trade, stamina, health, range, capacity,
				money, theMap);

		super.setCurrent(theMap.getRandomTown());
		stake = 0;
	}

	/**
	 * @param other
	 *            other person
	 * @param stake
	 *            wager
	 */
	public void stake(Person other, int stake) {
		if (getWallet().checkAmount(stake)
				&& other.getWallet().checkAmount(stake)) {
			getWallet().updateMoney(stake);
			other.getWallet().updateMoney(-stake);
			this.stake = stake;
		}
	}

	/**
	 * @param other
	 *            other person
	 */
	public void lose(Person other) {
		getWallet().updateMoney(-2 * stake);
		other.getWallet().updateMoney(2 * stake);

		this.stake = 0;
	}

}
