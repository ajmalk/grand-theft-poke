package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class AgilityRoid extends Item implements Usable{
	
	public void use(Person person) {
		person.setAgility(2);
	}
	
	public void unUse(Person person){
		person.setAgility(-2);
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Agility Roid";
	}

	@Override
	public String getDescription() {
		return "The Agiliy Steriod permently adds \n " +
				"2 agility points to your current standings.\n" +
				"This is useful because you can move further \n"+
				"distances in 1 turn.\n"+
				"+2 Agility Point";
	}
}