<<<<<<< HEAD
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthPotion extends Item implements Usable {
    @Override
	public int hashCode() {
		return 0;
	}
	
	public boolean Use(Person person) {
		int health = person.getHealth();
		int maxHealth = person.getMaxHealth();
		if(health<=(maxHealth-20)){
			health +=20;
		}
		else{
			health = maxHealth;
		}
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
        final HealthPotion other = (HealthPotion) obj;
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
=======
package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Usable;
import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthPotion extends Item implements Usable {
    @Override
	public int hashCode() {
		return 0;
	}
	
	public boolean Use(Person person) {
		int health = person.getHealth();
		int maxHealth = person.getMaxHealth();
		if(health<=(maxHealth-20)){
			health +=20;
		}
		else{
			health = maxHealth;
		}
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
        final HealthPotion other = (HealthPotion) obj;
        return true;
    }

	@Override
	public String toString() {
		return "Health Potion";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 24f674153a8d84ce475e7767c4912f6b48912437
}