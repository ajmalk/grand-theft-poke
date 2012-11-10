package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthVitamin extends Item implements Usable {

    public void use(Person person) {
        int maxHealth = person.getMaxHealth();
        person.setMaxHealth(maxHealth + 25);
    }

    
    public void unUse(Person person) {
    	int maxHealth = person.getMaxHealth();
		person.setMaxHealth(maxHealth - 25);
		if(person.getMaxHealth() > person.getHealth()) {
			person.setHealth(maxHealth);
		}
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
		return "Health Vitamin";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
