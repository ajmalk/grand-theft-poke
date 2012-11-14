package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import java.util.HashMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.*;
/**
 *
 * @author Ben Nuttle
 */
public class GlobalItemReference{
    private Arcanine myArcanine;
    private Charizard myCharizard;
    private JigglyPuff myJigglyPuff;
    private Pikachu myPikachu;
    private Squirtle mySquirtle;
    private HealthPotion myHealthPotion;
    private AgilityRoid myAgilityRoid;
    private HealthRoid myHealthRoid;
    private StaminaRoid myStaminaRoid;
    private StrengthRoid myStrengthRoid;
    private TradeRoid myTradeRoid;
    private AgilityVitamin myAgilityVitamin;
    private HealthVitamin myHealthVitamin;
    private StaminaVitamin myStaminaVitamin;
    private StrengthVitamin myStrengthVitamin;
    private TradeVitamin myTradeVitamin;
    private Repel myRepel;
	private HashMap map;
    
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

    public Item getArcanine() {
        return myArcanine;
    }

    public Item getCharizard() {
        return myCharizard;
    }

    public Item getJigglyPuff() {
        return myJigglyPuff;
    }

    public Item getPikachu() {
        return myPikachu;
    }

    public Item getSquirtle() {
        return mySquirtle;
    }

    public Item getHealthPotion() {
        return myHealthPotion;
    }

    public Item getAgilityRoid() {
        return myAgilityRoid;
    }

    public Item getHealthRoid() {
        return myHealthRoid;
    }

    public Item getStaminaRoid() {
        return myStaminaRoid;
    }

    public Item getStrengthRoid() {
        return myStrengthRoid;
    }

    public Item getTradeRoid() {
        return myTradeRoid;
    }

    public Item getAgilityVitamin() {
        return myAgilityVitamin;
    }

    public HealthVitamin getHealthVitamin() {
        return myHealthVitamin;
    }

    public Item getStaminaVitamin() {
        return myStaminaVitamin;
    }

    public Item getStrengthVitamin() {
        return myStrengthVitamin;
    }

    public Item getTradeVitamin() {
        return myTradeVitamin;
    }

    public Item getRepel() {
        return myRepel;
    }
}
