/**
 * GlobalItemReference.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * this is a global item reference
 * @author Team Rocket
 * @version 1.0
 */
public class GlobalItemReference {
	/**
	 * Field myArcanine.
	 */
	private final Arcanine myArcanine;
	
	/**
	 * Field myCharizard.
	 */
	private final Charmander myCharizard;
	
	/**
	 * Field myBulbasaur;
	 */
	private final Bulbasaur myBulbasaur;
	/**
	 * Field myJigglyPuff.
	 */
	private final JigglyPuff myJigglyPuff;
	
	/**
	 * Field myPikachu.
	 */
	private final Pikachu myPikachu;
	
	/**
	 * Field mySquirtle.
	 */
	private final Squirtle mySquirtle;
	
	/**
	 * Field myHealthPotion.
	 */
	private final HealthPotion myHealthPotion;
	
	/**
	 * Field myAgilityRoid.
	 */
	private final AgilityRoid myAgilityRoid;
	
	/**
	 * Field myHealthRoid.
	 */
	private final HealthRoid myHealthRoid;
	
	/**
	 * Field myStaminaRoid.
	 */
	private final StaminaRoid myStaminaRoid;
	
	/**
	 * Field myStrengthRoid.
	 */
	private final StrengthRoid myStrengthRoid;
	
	/**
	 * Field myTradeRoid.
	 */
	private final TradeRoid myTradeRoid;
	
	/**
	 * Field myAgilityVitamin.
	 */
	private final AgilityVitamin myAgilityVitamin;
	
	/**
	 * Field myHealthVitamin.
	 */
	private final HealthVitamin myHealthVitamin;
	
	/**
	 * Field myStaminaVitamin.
	 */
	private final StaminaVitamin myStaminaVitamin;
	
	/**
	 * Field myStrengthVitamin.
	 */
	private final StrengthVitamin myStrengthVitamin;
	
	/**
	 * Field myTradeVitamin.
	 */
	private final TradeVitamin myTradeVitamin;
	
	/**
	 * Field myRepel.
	 */
	private final Repel myRepel;

	/**
	 * Empty Constructor
	 */
	public GlobalItemReference() {
		myArcanine = new Arcanine();
		myCharizard = new Charmander();
		myBulbasaur = new Bulbasaur();
		myJigglyPuff = new JigglyPuff();
		myPikachu = new Pikachu();
		mySquirtle = new Squirtle();
		myHealthPotion = new HealthPotion();
		myAgilityRoid = new AgilityRoid();
		myHealthRoid = new HealthRoid();
		myStaminaRoid = new StaminaRoid();
		myStrengthRoid = new StrengthRoid();
		myTradeRoid = new TradeRoid();
		myAgilityVitamin = new AgilityVitamin();
		myHealthVitamin = new HealthVitamin();
		myStaminaVitamin = new StaminaVitamin();
		myStrengthVitamin = new StrengthVitamin();
		myTradeVitamin = new TradeVitamin();
		myRepel = new Repel();
	}

	/**
	
	 * @return myArcanine */
	public Item getArcanine() {
		return myArcanine;
	}

	/**
	
	 * @return myCharizard */
	public Item getCharmander() {
		return myCharizard;
	}
	
	/**
	 
	 * @return myBulbasaur */
	public Item getBulbasaur() {
		return myBulbasaur;
	}

	/**
	
	 * @return myJigglyPuff */
	public Item getJigglyPuff() {
		return myJigglyPuff;
	}

	/**
	
	 * @return myPikachu */
	public Item getPikachu() {
		return myPikachu;
	}

	/**
	 * getter for charizard
	 */
	public Item getCharizard() {
		return myCharizard;
	}
	/**
	
	 * @return mySquirtle */
	public Item getSquirtle() {
		return mySquirtle;
	}

	/**
	
	 * @return myHealthPotion */
	public Item getHealthPotion() {
		return myHealthPotion;
	}

	/**
	
	 * @return myAgilityRoid */
	public Item getAgilityRoid() {
		return myAgilityRoid;
	}

	/**
	
	 * @return myHealthRoid */
	public Item getHealthRoid() {
		return myHealthRoid;
	}

	/**
	
	 * @return myStaminaRoid */
	public Item getStaminaRoid() {
		return myStaminaRoid;
	}

	/**
	
	 * @return myStrengthRoid */
	public Item getStrengthRoid() {
		return myStrengthRoid;
	}

	/**
	
	 * @return myTradeRoid */
	public Item getTradeRoid() {
		return myTradeRoid;
	}

	/**
	
	 * @return myAgilityVitamin */
	public Item getAgilityVitamin() {
		return myAgilityVitamin;
	}

	/**
	
	 * @return myHealthVitamin */
	public HealthVitamin getHealthVitamin() {
		return myHealthVitamin;
	}

	/**
	
	 * @return myStaminaVitamin */
	public Item getStaminaVitamin() {
		return myStaminaVitamin;
	}

	/**
	
	 * @return myStrengthVitamin */
	public Item getStrengthVitamin() {
		return myStrengthVitamin;
	}

	/**
	
	 * @return myTradeVitamin */
	public Item getTradeVitamin() {
		return myTradeVitamin;
	}

	/**
	
	 * @return myRepel */
	public Item getRepel() {
		return myRepel;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Global Item Reference";
	}
}
