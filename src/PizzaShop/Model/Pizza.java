package PizzaShop.Model;

import PizzaShop.Exceptions.PizzaException;

import java.util.ArrayList;
import java.util.List;

/**
 * Object represents pizza.
 * Pizza is define with the attributes:
 * name, list of toppings and size.
 */
public class Pizza {

    private String name;
    private int id;
    private List<Topping> toppings;
    private PizzaSize pizzaSize;
    private int price;

    /**
     * Creates list of toppings and sets the default price to 0.
     */
    public Pizza() {
        this.toppings = new ArrayList<>();
        this.price = 0;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }

    /**
     * Sets name of pizza
     * @param name of pizza
     */
    public void setName(String name) throws PizzaException {
        if(name != null || !(name.trim().isEmpty())) {
            this.name = name;
        } else {
            throw new PizzaException("Name can't be empty. Please type a name.");
        }
    }

    /**
     * @return name of the pizza
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates the total price of the pizza
     * @return price of pizza
     */
    public int totalPrice(){
        price = pizzaSize.getPrice();
        for(Topping topping : toppings){
            price += topping.getPrice();
        }
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Sets pizza size
     * @param pizzaSize
     */
    public void setPizzaSize(PizzaSize pizzaSize) throws PizzaException {
        if(pizzaSize != null) {
            this.pizzaSize = pizzaSize;
        } else {
            throw new PizzaException("Size can't be empty. Please select a Size.");
        }
    }

    /**
     * @return pizza size
     */
    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    /**
     * @return list of toppings
     */
    public List<Topping> getToppings() {
        return new ArrayList<>(toppings);
    }

    /**
     * Add topping to the list
     * @param topping
     */
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id);
        sb.append(" Name: " + name);
        sb.append(" Size: " + pizzaSize + " with toppings: ");
        for(Topping topping : toppings){
            sb.append(topping + " ");
        }
        sb.append(" Price: " + price);
        return sb.toString();
    }
}
