package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

//import edu.gatech.CS2340.grandtheftpoke.Person;
public class Pokeball extends Item{
	public Pokeball(){
		//setWeight(1);
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
    /**
     * Returns a string of the item's name
     * @return string name of the item
     */
    @Override
    public String toString(){
    	return "Pokeball";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
