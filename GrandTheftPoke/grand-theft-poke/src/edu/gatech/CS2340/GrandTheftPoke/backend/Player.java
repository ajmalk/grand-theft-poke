package edu.gatech.CS2340.GrandTheftPoke.backend;

/**
 *
 * @author Team Rocket
 */
public class Player extends Person {

    private static final int START_SKILLS = 16;
    private static final int START_MONEY = 5000;
    public Player(String name, int strength, int agility, int trade, int stamina, int health, int range, int capacity, GameMap theMap) {
            super(name, strength, agility, trade, stamina, health, range, capacity, START_MONEY, theMap);
    }

    
    public static boolean checkStart(int strength, int agility, int trade, int stamina){
        return strength + agility + trade + stamina == START_SKILLS;
    }

    @Override
    public void postBattle(Person other) {
    }
    
    @Override
    public String toString() {
        return "Name:" + getName() + " Strength:" + getStrength() + " Agility:" + getAgility() + " Trade:" + getTrade() + " Stamina:" + getStamina() + " Health:" + getHealth();
    }
}
