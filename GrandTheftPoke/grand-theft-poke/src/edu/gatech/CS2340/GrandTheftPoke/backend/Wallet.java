package edu.gatech.CS2340.GrandTheftPoke.backend;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * The wallet keeps track of the person's money and allows for updates when
 * buying and selling goods
 * 
 * @author Team Rocket
 * 
 */
public class Wallet {
	@XStreamAsAttribute
	private Float money;

	/**
	 * Instantiates the wallet
	 * 
	 * @param num
	 *            the amount to be help in the wallet
	 */
	public Wallet(Float num) {
		this.money = num;
	}

	/**
	 * Returns if the inputted wallet is equal to the current wallet
	 * 
	 * @param wallet
	 * @return boolean
	 */
	public boolean equals(Wallet wallet) {
		return money == wallet.money;
	}

	/**
	 * Adds or subtracts money from the wallet; mostly used for buying and
	 * selling goods or services.
	 * 
	 * @param num
	 *            the amount wanted to be added to wallet
	 */
	public void updateMoney(float num) {
		money += num;
	}

	/**
	 * Returns the amount in this wallet
	 * 
	 * @return money the amount in the wallet
	 */
	public float getMoney() {
		return money;
	}

	/**
	 * Checks if an item or good costs more than your wallet contains; this
	 * determines if you can afford an item.
	 * 
	 * @param amount
	 *            the cost of the item or service
	 * @return boolean true if you can afford the item
	 */
	public boolean checkAmount(float amount) {
		return money >= amount;
	}

	@Override
	public String toString() {
		return "Wallet [money=" + money + "]";
	}
}
