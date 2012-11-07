package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;


public class TradeRoid extends Item implements Usable{
    @Override
	public int hashCode() {
		return 17;
	}
	
    @Override
	public boolean Use(Person person) {
		person.setTrade(2);
		return false;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TradeRoid other = (TradeRoid) obj;
        return true;
    }

	@Override
	public String toString() {
		return "Trade Steriod";
	}

	@Override
	public String getDescription() {
		return "The Trade Steriod permently adds \n " +
				"2 stamina points to your current standings.\n" +
				"Increasing trade ability allows you to become \n"+
				"a master trader, thus allowing you to negociate the \n"+
				"the most competive pricing!\n"+
				"+2 Trade Point";
	}
}