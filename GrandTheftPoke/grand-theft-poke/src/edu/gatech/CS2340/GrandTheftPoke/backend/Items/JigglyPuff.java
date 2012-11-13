package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class JigglyPuff extends Pokemon implements Usable {

	public JigglyPuff() {
		super(1,2,3,4);
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
	public void use(Person person){
		super.use(person);
	}
	
	@Override
	public void unUse(Person person) {
		super.unUse(person);
	}
	@Override
	public String toString() {
		return "Jiggly Puff Pokemon";
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}