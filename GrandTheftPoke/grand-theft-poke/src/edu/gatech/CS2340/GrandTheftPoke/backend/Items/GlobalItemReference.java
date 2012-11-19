package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * 
 * @author Team Rocket
 */
public class GlobalItemReference {
	
	final private Arcanine myArcanine;
	
	final private Charizard myCharizard;
	
	final private JigglyPuff myJigglyPuff;
	
	final private Pikachu myPikachu;
	
	final private Squirtle mySquirtle;
	
	final private HealthPotion myHealthPotion;
	
	final private AgilityRoid myAgilityRoid;
	
	final private HealthRoid myHealthRoid;
	
	final private StaminaRoid myStaminaRoid;
	
	final private StrengthRoid myStrengthRoid;
	
	final private TradeRoid myTradeRoid;
	
	final private AgilityVitamin myAgilityVitamin;
	
	final private HealthVitamin myHealthVitamin;
	
	final private StaminaVitamin myStaminaVitamin;
	
	final private StrengthVitamin myStrengthVitamin;
	
	final private TradeVitamin myTradeVitamin;
	
	final private Repel myRepel;

	/**
	 * Empty Constructor
	 */
	public GlobalItemReference() {
		myArcanine = new Arcanine();
		myCharizard = new Charizard();
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
	 * @return myArcanine
	 */
	public Item getArcanine() {
		return myArcanine;
	}

	/**
	 * @return myCharizard
	 */
	public Item getCharizard() {
		return myCharizard;
	}

	/**
	 * @return myJigglyPuff
	 */
	public Item getJigglyPuff() {
		return myJigglyPuff;
	}

	/**
	 * @return myPikachu
	 */
	public Item getPikachu() {
		return myPikachu;
	}

	/**
	 * @return mySquirtle
	 */
	public Item getSquirtle() {
		return mySquirtle;
	}

	/**
	 * @return myHealthPotion
	 */
	public Item getHealthPotion() {
		return myHealthPotion;
	}

	/**
	 * @return myAgilityRoid
	 */
	public Item getAgilityRoid() {
		return myAgilityRoid;
	}

	/**
	 * @return myHealthRoid
	 */
	public Item getHealthRoid() {
		return myHealthRoid;
	}

	/**
	 * @return myStaminaRoid
	 */
	public Item getStaminaRoid() {
		return myStaminaRoid;
	}

	/**
	 * @return myStrengthRoid
	 */
	public Item getStrengthRoid() {
		return myStrengthRoid;
	}

	/**
	 * @return myTradeRoid
	 */
	public Item getTradeRoid() {
		return myTradeRoid;
	}

	/**
	 * @return myAgilityVitamin
	 */
	public Item getAgilityVitamin() {
		return myAgilityVitamin;
	}

	/**
	 * @return myHealthVitamin
	 */
	public HealthVitamin getHealthVitamin() {
		return myHealthVitamin;
	}

	/**
	 * @return myStaminaVitamin
	 */
	public Item getStaminaVitamin() {
		return myStaminaVitamin;
	}

	/**
	 * @return myStrengthVitamin
	 */
	public Item getStrengthVitamin() {
		return myStrengthVitamin;
	}

	/**
	 * @return myTradeVitamin
	 */
	public Item getTradeVitamin() {
		return myTradeVitamin;
	}

	/**
	 * @return myRepel
	 */
	public Item getRepel() {
		return myRepel;
	}
}
