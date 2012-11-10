package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.Person;

public class Arcanine extends Pokemon implements Usable{
	
	public Arcanine() {
		super(1,2,3,4);
	}
	
	public void use(Person person){
		super.use(person);
	}
	
	public void unUse(Person person) {
		super.unUse(person);
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
		return "Arcanine Pokemon";
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}