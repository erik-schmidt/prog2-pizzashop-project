package PizzaShop.Model;

import PizzaShop.Exceptions.PizzaException;
import PizzaShop.IO.PizzaIOHandler;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This Object represents a Pizza service.
 * Pizza service is defined by:
 * list of pizzas and counter for ID
 */
public class PizzaService {

    private List<Pizza> pizzas;
    private static int counter;
    private DefaultListModel<String> sizeDefaultListModel;
    private DefaultListModel<String> toppingDefaultListModel;
    private DefaultListModel<Pizza> pizzaDefaultListModel;
    private PizzaIOHandler pizzaIOHandler;

    /**
     * Creates a list of pizzas and sets the counter to 0.
     */
    public PizzaService() {
        this.pizzas = new ArrayList<>();
        counter = 0;
        pizzaIOHandler = new PizzaIOHandler();
    }

    /**
     * Creates pizza and adds it to the list
     * @param pizza
     */
    public void create(Pizza pizza){
        pizza.setID(counter++);
        pizzas.add(pizza);
    }

    /**
     * Updates pizza to correct information or further informations
     * @param pizza
     */
    public void update(Pizza pizza, Pizza newPizza){
        for(Pizza p : pizzas){
            if(p.getID() == pizza.getID()){
                pizzas.remove(p);
                newPizza.setID(pizza.getID());
                pizzas.add(newPizza);
                break;
            }
        }
    }

    /**
     * Removes pizza from the list
     * @param pizza
     */
    public void delete(Pizza pizza){
        for(Pizza p : pizzas){
            if(pizza.getID() == p.getID()){
                pizzas.remove(p);
                break;
            }
        }
    }

    /**
     * Searches for the pizza in the list with given ID
     * @param id
     * @return {@see pizza}
     */
    public Pizza read(int id){
        for(Pizza pizza : pizzas){
            if(pizza.getID() == id){
                return pizza;
            }
        }
        return null;
    }

    /**
     * Sets a list model with Pizza sizes in it.
     * @return size list model
     */
    public DefaultListModel setSizeDefaultListModel(){
        sizeDefaultListModel = new DefaultListModel<>();
        for(PizzaSize pizzaSize : PizzaSize.values()){
            sizeDefaultListModel.addElement(pizzaSize.getName());
        }
        return sizeDefaultListModel;
    }

    /**
     * Sets a list model with toppings in it.
     * @return topping list model
     */
    public DefaultListModel setToppingDefaultListModel(){
        toppingDefaultListModel = new DefaultListModel<>();
        for(Topping topping : Topping.values()){
            toppingDefaultListModel.addElement(topping.getName());
        }
        return toppingDefaultListModel;
    }

    public DefaultListModel<Pizza> setPizzaDefaultListModel(){
        pizzaDefaultListModel = new DefaultListModel<>();
        for(Pizza pizza : pizzas){
            pizzaDefaultListModel.addElement(pizza);
        }
        return pizzaDefaultListModel;
    }

    /**
     * @return list of pizzas from give filename
     */
    public List<Pizza> getAll(String path) throws IOException, PizzaException {
        pizzas = new ArrayList<>(pizzaIOHandler.read(path));
        return pizzaIOHandler.read(path);
    }

    /**
     * returns list of pizzas
     * @return
     */
    public List<Pizza> getPizzas(){
        return new ArrayList<>(pizzas);
    }

    /**
     * Saves all pizzas in a text file.
     * @param pizzas
     * @throws IOException
     */
    public void saveAll(List<Pizza> pizzas, String path) throws IOException {
        pizzaIOHandler.write(pizzas, path);
    }
}
