package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;

public class GymLeader extends Person {
	private int stake;

	public GymLeader(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap) {
		super(name, strength, agility, trade, stamina, health, range, capacity,
				money, theMap);

		super.setCurrent(theMap.getRandomTown());
		stake = 0;
	}

	public void stake(Person other, int stake) {
		if (getWallet().checkAmount(stake)
				&& other.getWallet().checkAmount(stake)) {
			getWallet().updateMoney(stake);
			other.getWallet().updateMoney(-stake);
			this.stake = stake;
		}
	}

	public void lose(Person other) {
		getWallet().updateMoney(-2 * stake);
		other.getWallet().updateMoney(2 * stake);

		this.stake = 0;
	}

}
