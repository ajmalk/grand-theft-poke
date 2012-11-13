package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Ben Nuttle
 */
public class GlobalItemReference implements Set{
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
    private Item[] items;
    private int size;
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
        size = 17;
        items = new Item[size];
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

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public int size() {
		return 17;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
