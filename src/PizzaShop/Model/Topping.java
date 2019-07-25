package PizzaShop.Model;

/**
 * Object represents toppings for the pizzas.
 * Toppings are defined with:
 * price (in cent) and name.
 */
public enum Topping {

    TOMATO(200, "Tomate"), CHILI(300, "Chili"), CHEESE(200, "Käse"),
    MUSHROOMS(300, "Pilze"), SALAMI(200, "Salami");

    private int price;
    private String name;

    /**
     * Creates Topping for pizza with price and name.
     * @param price
     * @param name
     */
    Topping(int price, String name) {
        this.price = price;
        this.name = name;
    }

    /**
     * @return price of the topping
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return name of the topping
     */
    public String getName() {
        return name;
    }
}
