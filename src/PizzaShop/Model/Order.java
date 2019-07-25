package PizzaShop.Model;

import PizzaShop.Exceptions.OrderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Object represents an Order.
 * Order is defined by:
 * ID, List of pizzas and status of order.
 */
public class Order {

    private String id;
    private List<Pizza> pizzas;
    private boolean completed;

    /**
     * Creates an Order and sets an ID
     * @param id
     */
    public Order(String id) {
        this.id = id;
        completed = false;
        this.pizzas = new ArrayList<>();
    }

    /**
     * Adds {@link Pizza} to list.
     * @param pizza
     * @throws OrderException if status is completed
     */
    public void addPizza(Pizza pizza) throws OrderException {
        if(completed) {
            pizzas.add(pizza);
        } else {
            throw new OrderException("Orders are completed. No pizza can't be added.");
        }
    }
    /**
     * @return List of pizzas
     */
    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }

    /**
     * @return ID of order
     */
    public String getId() {
        return id;
    }

    /**
     * @return Status of order
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the status of order
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id);
        sb.append("Pizzas: " + pizzas);
        sb.append("Status: " + completed);
        return sb.toString();
    }
}
