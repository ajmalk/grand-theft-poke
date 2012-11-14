package edu.gatech.CS2340.GrandTheftPoke.backend;

import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

public class ItemTypes{
	public enum Commodities implements Item{
		Pokeball("Pokeball", 1, 
				"Regular Pokeball");
		
		private String name;
		private int weight;
		private String description;
		
		private Commodities(String name, int weight, String description){
			this.name = name;
			this.weight = weight;
			this.description = description;
		}
		
		public String toString(){
			return name;
		}
		public int getWeight(){
			return weight;
		}
	    public String getDescription(){
	    	return description;
	    }
	}
	
	public enum Potions implements Item, Usable{
		Repel("Repel", 1,
				"Repels stuff"),
		AgilityRoid("Agility Roid", 1, 
				"Boosts Agility");
		
		private String name;
		private int weight;
		private String description;
		
		private Potions(String name, int weight, String description){
		this.name = name;
		this.weight = weight;
		this.description = description;
		}
		
		public String toString(){
			return name;
		}
		public int getWeight(){
			return weight;
		}
	    public String getDescription(){
	    	return description;
	    }
		@Override
		public void use(Person person) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void unUse(Person person) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public enum Pokemon implements Item{
		Pikachu("Pikachu", 1,
				"Pikachu stuff");
		
		private String name;
		private int weight;
		private String description;
		
		private Pokemon(String name, int weight, String description){
		this.name = name;
		this.weight = weight;
		this.description = description;
		}
		
		public String toString(){
			return name;
		}
		public int getWeight(){
			return weight;
		}
	    public String getDescription(){
	    	return description;
	    }
	}
}
