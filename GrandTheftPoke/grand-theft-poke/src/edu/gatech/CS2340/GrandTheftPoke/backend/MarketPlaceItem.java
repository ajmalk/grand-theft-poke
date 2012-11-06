package edu.gatech.CS2340.GrandTheftPoke.backend;

/**
 * Represents the price and stock properties of an item in the marketplace
 *
 * @author Team Rocket
 *
 */
public class MarketPlaceItem {

    private float price,
            stock;
    private final float EQIL_PRICE,
            EQIL_STOCK,
            CONS_ELASTICITY,
            PROD_ELASTICITY,
            STOCK_RATIO;

    /**
     * Creates a MarketPlaceItem
     *
     * @param price the equilibrium price of the item in this marketplace
     * @param stock  
     */
    public MarketPlaceItem(int price, int stock) {
        EQIL_PRICE = this.price = price;
        EQIL_STOCK = this.stock = stock;
        CONS_ELASTICITY = -1;
        PROD_ELASTICITY = 2;
        STOCK_RATIO = 0.1f;
    }

    /**
     * returns the current retail price
     *
     * @return the price truncated to 2 decimal places
     */
    public float getPrice() {
        return ((int) (price * 100)) / 100; //probably a better way to do this
    }

    /**
     * returns the total price if buying a certain amount of the item
     *
     * @param amount 
     * @return the price truncated to 2 decimal places
     */
    public float getBuyingPrice(int amount) {
        if (amount < 0) {
            return 0;
        }
        float price = 0;
        for (int i = 0; i < amount; i++) {
            price += getNewPrice(-1);
        }
        return ((int) (price * 100)) / 100; //probably a better way to do this
    }

    /**
     * returns the total price if selling a certain amount of the item
     *
     * @param amount 
     * @return the price truncated to 2 decimal places
     */
    public float getSellingPrice(int amount) {
        if (amount < 0) {
            return 0;
        }
        float price = 0;
        for (int i = 0; i < amount; i++) {
            price += getNewPrice(-1);
        }
        return ((int) (price * 100)) / 100; //probably a better way to do this
    }

    /**
     * The current stock level
     * @return 
     */
    public int getStock() {
        return (int) stock;
    }

    private float consumption(float price) {
        return (float) Math.pow((price / EQIL_PRICE), CONS_ELASTICITY) * EQIL_STOCK;
    }

    private float production(float price) {
        return (float) Math.pow((price / EQIL_PRICE), PROD_ELASTICITY) * EQIL_STOCK;
    }

    private float consumption() {
        return consumption(price);
    }

    private float production() {
        return production(price);
    }

    private float getNewPrice(float amount) {
        float temp, price = this.price;
        amount += stock - EQIL_STOCK;
        do {
            temp = consumption(price) - production(price) - amount;
            temp /= -CONS_ELASTICITY * Math.pow(EQIL_PRICE, PROD_ELASTICITY) * Math.pow(price, CONS_ELASTICITY - 1)
                    + PROD_ELASTICITY * Math.pow(EQIL_PRICE, CONS_ELASTICITY) * Math.pow(price, PROD_ELASTICITY - 1);
            temp += price;
            if (Math.abs(price - temp) < 0.001) {
                break;
            }
            price = temp;
        } while (true);
        return price;
    }

    /**
     * updates the stock and price level to the next iteration (turn). Should be
     * called once every turn.
     *
     * @return true if successful
     */
    public boolean update() {
        if (Math.abs(price - EQIL_PRICE) < 0.001) {
            return true;
        }
        float change = (production(price) - consumption(price)) * STOCK_RATIO;
        price = getNewPrice(change);
        stock += change;
        return true;
    }

    /**
     * buys "amount" items from the market
     *
     * @param amount 
     * @return the total price of the transaction
     */
    public float buy(int amount) {
        if (amount < 0 || amount > stock) {
            return 0;
        }
        float price = getBuyingPrice(amount);
        stock -= amount;
        this.price = getNewPrice(-amount);
        return price;
    }

    /**
     * sells "amount" items to the market
     *
     * @param amount 
     * @return the total price of the transaction
     */
    public float sell(int amount) {
        if (amount < 0) {
            return 0;
        }
        float price = getSellingPrice(amount);
        stock += amount;
        this.price = getNewPrice(amount);
        return price;
    }
}