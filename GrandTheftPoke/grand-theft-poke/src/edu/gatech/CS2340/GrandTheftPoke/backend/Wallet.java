package edu.gatech.CS2340.GrandTheftPoke.backend;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Wallet {
	@XStreamAsAttribute
    private Float money;

	
	
    public Wallet(Float num) {
        this.money = num;
    }

    public boolean equals(Wallet wallet){
    	return money == wallet.money;
    }
    public void updateMoney(float num) {
        money += num;
    }

    public float getMoney() {
        return money;
    }
    
    public boolean checkAmount(float amount) {
        return money >= amount;
    }
    
    @Override
    public String toString() {
        return "Wallet: " + money;
    }
}
