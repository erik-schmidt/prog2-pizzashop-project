package PizzaShop.Model;

/**
 * Object represents pizza sizes.
 * Pizza sizes are defined with:
 * price (in cent) and name.
 */
public enum PizzaSize {
    SMALL(400, "Klein"), MEDIUM(500, "Mittel"), LARGE(600, "Groß"),
    FAMILY(700, "Familie");

    private int price;
    private String name;

    /**
     * Creates pizza size with price and name.
     * @param price
     * @param name
     */
    PizzaSize(int price, String name) {
        this.price = price;
        this.name = name;
    }

    /**
     * @return price of size
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return name of size
     */
    public String getName() {
        return name;
    }
}
