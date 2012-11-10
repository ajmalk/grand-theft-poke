package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthPotion extends Item implements Usable {
	
	public void use(Person person) {
		int health = person.getHealth();
		int maxHealth = person.getMaxHealth();
		if(health<=(maxHealth-20)){
			person.setHealth(health + 20);
		}
		else{
			person.setHealth(maxHealth);
		}
	}
	
	public void unUse(Person person) {
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
		return "Health Potion";
	}

	@Override
	public String getDescription() {
		return "Health Potion restores your health to \n"+
				"to the maximum. This is allows you\n"+
				"stay alive longer.\n"+
				"Health = max";
				
	}
}
