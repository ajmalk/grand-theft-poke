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
	
	private int strength, agility, trade, stamina, currentStamina, maxHealth;
	
	@XStreamAsAttribute
	private Integer health;
	
	private Backpack myBackpack;

	private Town currentTown;
	
	private Wallet myWallet;
	
	@XStreamOmitField
	private GameMap theMap;

	
	public Person(){
		
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
	 * @return
	 */
	public int getStrength() {
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
	 * @return
	 */
	public int getAgility() {
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
	 * @return
	 */
	public int getTrade() {
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
	 * @return
	 */
	public int getStamina() {
		return this.stamina;
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * 
	 * @return
	 */
	public int getHealth() {
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
	 * @return
	 */
	public Backpack getBackpack() {
		return myBackpack;
	}

	/**
	 * 
	 * @return
	 */
	public Wallet getWallet() {
		return myWallet;
	}

	/**
	 * 
	 * @return
	 */
	public Town getCurrent() {
		return currentTown;
	}
	
	public void setCurrent(Town newCurrent) {
		currentTown = newCurrent;
	}

	/**
	 * 
	 * @param other
	 * @return
	 */
	public int attack() {
		float fatigue = currentStamina/stamina;
		if(currentStamina > 0) {
			currentStamina--;
		}
		return (int)fatigue*strength;
		
	}
	
	public void defend(int incomingDamage) {
		float fatigue = currentStamina/stamina;
		float dodge = agility/100;
		
		Random rand = new Random();
		double chance = rand.nextDouble();
		
		if(chance > fatigue*dodge) {
			return;
		}
		
		setHealth(-incomingDamage);
	}
	
	public boolean flee() {
		return new Random().nextBoolean();
	}

	/**
	 * 
	 * @param destination
	 */
	public void move(Town destination) {
		if (!(currentTown.toString().equals(destination.toString()))) {
			int range = myBackpack.getMaxRange();
			int distance = theMap.Dijkstras(currentTown, destination.toString());
			if (range >= distance && health >= distance/5) {
				currentTown = destination;
				setHealth(-distance/5);
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
		if(theMarket.getStock().containsKey(desiredGood)) {
			float price = (float)(1.15 - 0.0015 * trade) * ((MarketPlaceItem) (theMarket.getStock().get(desiredGood)))
					.getBuyingPrice(quantity);
			if (price != 0) {
				if (myWallet.checkAmount(price)) {
					if (myBackpack.checkCapacity(desiredGood, quantity)) {
						theMarket.buy(desiredGood, quantity);
						myWallet.updateMoney(-price);
						myBackpack.place(desiredGood, quantity);
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
			float price = (float)(0.85 + 0.0015 * trade) * theMarket.sell(desiredGood, quantity);
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
		Set<Item> theirStuff = other.getBackpack().getContents().keySet();
		for(Item theItem : theirStuff) {
			int quantity = other.getBackpack().getContents().get(theItem);
			if(myBackpack.place(theItem, quantity)) {
				other.getBackpack().remove(theItem, quantity);
			}
			//myWallet.updateMoney(other.getWallet().getMoney());
			
		}
		
	}
	@Override
    public String toString() {
        return this.getClass() + "Name:" + getName() + " Strength:" + getStrength() + " Agility:" + getAgility() + " Trade:" + getTrade() + " Stamina:" + getStamina() + " Health:" + getHealth();
    }
}
