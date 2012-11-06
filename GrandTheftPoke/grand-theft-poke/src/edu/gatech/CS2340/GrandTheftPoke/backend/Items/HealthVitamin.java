package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class HealthVitamin extends Vitamin {

    public boolean Use(Person person) {
        int maxHealth = person.getMaxHealth();
        person.setMaxHealth(maxHealth + 25);
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public boolean Use() {
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
        final HealthVitamin other = (HealthVitamin) obj;
        return true;
    }
}
