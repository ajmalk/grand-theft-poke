package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 * 
 * @author Team Rocket
 */
public class GlobalItemReference {
	private final Arcanine myArcanine;
	private final Charizard myCharizard;
	private final JigglyPuff myJigglyPuff;
	private final Pikachu myPikachu;
	private final Squirtle mySquirtle;
	private final HealthPotion myHealthPotion;
	private final AgilityRoid myAgilityRoid;
	private final HealthRoid myHealthRoid;
	private final StaminaRoid myStaminaRoid;
	private final StrengthRoid myStrengthRoid;
	private final TradeRoid myTradeRoid;
	private final AgilityVitamin myAgilityVitamin;
	private final HealthVitamin myHealthVitamin;
	private final StaminaVitamin myStaminaVitamin;
	private final StrengthVitamin myStrengthVitamin;
	private final TradeVitamin myTradeVitamin;
	private final Repel myRepel;

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
