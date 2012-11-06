package edu.gatech.CS2340.GrandTheftPoke.backend;

public class Wallet {

    private float money;

    public Wallet(int num) {
        this.money = num;
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
