package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import java.util.Random;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Wallet;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

/**
 * Contains shared data and methods for players and NPCs.
 * 
 * @author Team Rocket
 */
public abstract class Person {
	@XStreamAsAttribute
	private String name;

	private Integer strength, agility, trade, stamina, currentStamina,
			maxHealth;

	@XStreamAsAttribute
	private Integer health;

	private Wallet myWallet;

	private Town currentTown;

	private Backpack myBackpack;

	@XStreamOmitField
	private GameMap theMap;



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agility == null) ? 0 : agility.hashCode());
		result = prime * result
				+ ((currentStamina == null) ? 0 : currentStamina.hashCode());
		result = prime * result
				+ ((currentTown == null) ? 0 : currentTown.hashCode());
		result = prime * result + ((health == null) ? 0 : health.hashCode());
		result = prime * result
				+ ((maxHealth == null) ? 0 : maxHealth.hashCode());
		result = prime * result
				+ ((myBackpack == null) ? 0 : myBackpack.hashCode());
		result = prime * result
				+ ((myWallet == null) ? 0 : myWallet.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stamina == null) ? 0 : stamina.hashCode());
		result = prime * result
				+ ((strength == null) ? 0 : strength.hashCode());
		result = prime * result + ((theMap == null) ? 0 : theMap.hashCode());
		result = prime * result + ((trade == null) ? 0 : trade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Person other = (Person) obj;
		if (agility == null) {
			if (other.agility != null)
				return false;
		} else if (!agility.equals(other.agility))
			return false;
		if (currentStamina == null) {
			if (other.currentStamina != null)
				return false;
		} else if (!currentStamina.equals(other.currentStamina))
			return false;
		if (currentTown == null) {
			if (other.currentTown != null)
				return false;
		} else if (!currentTown.equals(other.currentTown))
			return false;
		if (health == null) {
			if (other.health != null)
				return false;
		} else if (!health.equals(other.health))
			return false;
		if (maxHealth == null) {
			if (other.maxHealth != null)
				return false;
		} else if (!maxHealth.equals(other.maxHealth))
			return false;
		if (myBackpack == null) {
			if (other.myBackpack != null)
				return false;
		} else if (!myBackpack.equals(other.myBackpack))
			return false;
		if (myWallet == null) {
			if (other.myWallet != null)
				return false;
		} else if (!myWallet.equals(other.myWallet))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stamina == null) {
			if (other.stamina != null)
				return false;
		} else if (!stamina.equals(other.stamina))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
			return false;
		if (theMap == null) {
			if (other.theMap != null)
				return false;
		} else if (!theMap.equals(other.theMap))
			return false;
		if (trade == null) {
			if (other.trade != null)
				return false;
		} else if (!trade.equals(other.trade))
			return false;
		return true;
	}

	/**
	 * Default constructor for person
	 */
	public Person() {

	}

	/**
	 * Constructs a person with the specified parameters.
	 * 
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
	 * @param theReference
	 */
	public Person(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap) {
		this.name = name;
		this.strength = strength;
		this.agility = agility;
		this.trade = trade;
		this.stamina = stamina;
		this.currentStamina = stamina;
		this.health = health;
		maxHealth = health;
		myWallet = new Wallet(money);

		myBackpack = new Backpack(range, capacity);
		currentTown = theMap.getStartTown();
		this.theMap = theMap;
	}

	/**
	 * Gets the name of the person
	 * 
	 * @return the person's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return strength
	 */
	public Integer getStrength() {
		return this.strength;
	}

	/**
	 * 
	 * @param strengthDiff
	 */
	public void setStrength(int strengthDiff) {
		this.strength += strengthDiff;
	}

	/**
	 * 
	 * @return agility
	 */
	public Integer getAgility() {
		return this.agility;
	}

	/**
	 * 
	 * @param agilityDiff
	 */
	public void setAgility(int agilityDiff) {
		this.agility += agilityDiff;
	}

	/**
	 * 
	 * @return trade
	 */
	public Integer getTrade() {
		return this.trade;
	}

	/**
	 * 
	 * @param tradeDiff
	 */
	public void setTrade(int tradeDiff) {
		this.trade += tradeDiff;
	}

	/**
	 * 
	 * @return stamina
	 */
	public Integer getStamina() {
		return this.stamina;
	}

	/**
	 * 
	 * @return maxHealth
	 */
	public Integer getMaxHealth() {
		return maxHealth;
	}

	/**
	 * 
	 * @return health
	 */
	public Integer getHealth() {
		return health;
	}

	/**
	 * 
	 * @param healthDiff
	 */
	public void setHealth(int healthDiff) {
		if (health <= (maxHealth - healthDiff)) {
			this.health += healthDiff;
		} else {
			health = maxHealth;
		}
	}

	/**
	 * 
	 * @param newMax
	 */
	public void setMaxHealth(int newMax) {
		this.maxHealth = newMax;
	}

	/**
	 * 
	 * @param staminaDiff
	 */
	public void setStamina(int staminaDiff) {
		this.stamina += staminaDiff;
	}

	/**
	 * 
	 * @return myBackpack
	 */
	public Backpack getBackpack() {
		return myBackpack;
	}

	/**
	 * 
	 * @return myWallet
	 */
	public Wallet getWallet() {
		return myWallet;
	}

	/**
	 * 
	 * @return currentTown
	 */
	public Town getCurrent() {
		return currentTown;
	}

	/**
	 * 
	 * @param newCurrent
	 */
	public void setCurrent(Town newCurrent) {
		currentTown = newCurrent;
	}

	/**
	 * 
	 * @param turnCount
	 * @return int
	 */
	public int attack(int turnCount) {
		final float fatigue = (float) currentStamina / stamina;
		if (currentStamina > 1 && turnCount % 5 == 0) {
			currentStamina--;
		}
		return (int) (fatigue * strength);

	}

	/**
	 * 
	 * @param incomingDamage
	 */
	public void defend(int incomingDamage) {
		final float fatigue = (float) currentStamina / stamina;
		final float dodge = agility / 100;

		final Random rand = new Random();
		final double chance = rand.nextDouble();

		if (chance < fatigue * dodge) {
			return;
		}

		setHealth(-incomingDamage);
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean flee() {
		return new Random().nextBoolean();
	}

	/**
	 * 
	 * @param destination
	 */
	public void move(Town destination) {
		if (!(currentTown.toString().equals(destination.toString()))) {
			final int range = myBackpack.getMaxRange();
			int distance = theMap
					.Dijkstras(currentTown, destination.toString());
			if (range >= distance && health >= distance / 5) {
				currentTown = destination;
				setHealth(-distance / 5);
			}
		}
	}

	/**
	 * 
	 * @param theMarket
	 * @param desiredGood
	 * @param quantity
	 * @return
	 */
	public boolean buy(MarketPlace theMarket, Item desiredGood, int quantity) {
		if (theMarket.getStock().containsKey(desiredGood)) {
			float price = (float) (1.15 - 0.0015 * trade)
					* ((MarketPlaceItem) (theMarket.getStock().get(desiredGood)))
							.getBuyingPrice(quantity);
			if (price != 0) {
				if (myWallet.checkAmount(price)) {
					if (myBackpack.checkCapacity(desiredGood, quantity)) {
						theMarket.buy(desiredGood, quantity);
						myWallet.updateMoney(-price);
						myBackpack.place(desiredGood, quantity);
						System.out.println(myBackpack.getCapacity());
						return true;
					}
				}
			}
		}

		return false;

	}

	/**
	 * 
	 * @param theMarket
	 * @param desiredGood
	 * @param quantity
	 * @return
	 */
	public boolean sell(MarketPlace theMarket, Item desiredGood, int quantity) {
		if (myBackpack.checkContents(desiredGood, quantity)) {
			final float price = (float) (0.85 + 0.0015 * trade)
					* theMarket.sell(desiredGood, quantity);
			myWallet.updateMoney(price);
			myBackpack.remove(desiredGood, quantity);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param other
	 */
	public void win(Person other) {
		final Set<Item> theirStuff = other.getBackpack().getContents().keySet();
		for (Item theItem : theirStuff) {
			int quantity = other.getBackpack().getContents().get(theItem);
			if (myBackpack.place(theItem, quantity)) {
				other.getBackpack().remove(theItem, quantity);
			}
		}
		float temp = Math.min(other.getWallet().getMoney(), getWallet()
				.getMoney());
		getWallet().updateMoney(temp);
		other.getWallet().updateMoney(-temp);

	}

	@Override
	public String toString() {
		return this.getClass() + "Name:" + getName() + " Strength:"
				+ getStrength() + " Agility:" + getAgility() + " Trade:"
				+ getTrade() + " Stamina:" + getStamina() + " Health:"
				+ getHealth();
	}
}
