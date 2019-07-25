package PizzaShop.IO;

import PizzaShop.Exceptions.PizzaException;
import PizzaShop.Model.Pizza;
import PizzaShop.Model.PizzaSize;
import PizzaShop.Model.Topping;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This Object represents an Input-Output Handler.
 */
public class PizzaIOHandler {

    /**
     * Reads a file with given name.
     * @param path
     * @return list of pizzas
     * @throws IOException
     * @throws PizzaException if informations about a pizza is wrong
     */
    public List<Pizza> read(String path) throws IOException, PizzaException {
        Path quellpfad = Paths.get(path);
        List<Pizza> pizzas = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(quellpfad)){
            String line;
            while((line = reader.readLine()) != null){
                Pizza pizza = new Pizza();
                String[] p = line.split("#");
                pizza.setID(Integer.parseInt(p[0]));
                pizza.setName(p[1]);
                for(PizzaSize pizzaSize : PizzaSize.values()){
                    if(pizzaSize.getName().equals(p[2])){
                        pizza.setPizzaSize(pizzaSize);
                    }
                }
                pizza.setPrice(Integer.parseInt(p[3]));
                for(Topping topping : Topping.values()){
                    for(int i = 0; i < p.length; i++){
                        if(topping.getName().equals(p[i])){
                            pizza.addTopping(topping);
                        }
                    }
                }
                pizzas.add(pizza);
            }
        }
        return pizzas;
    }

    /**
     * Writes a file with given name as filename.
     * @param pizzas
     * @throws IOException
     */
    public void write(List<Pizza> pizzas, String path) throws IOException {
        Path destination = Paths.get(path);
        try(BufferedWriter writer = Files.newBufferedWriter(destination)){
            String line;
            for(Pizza pizza : pizzas){
                StringBuilder sb = new StringBuilder();
                sb.append(pizza.getID());
                sb.append("#");
                sb.append(pizza.getName());
                sb.append("#");
                sb.append(pizza.getPizzaSize().getName());
                sb.append("#");
                sb.append(pizza.totalPrice());
                sb.append("#");
                for(Topping topping : pizza.getToppings()){
                    sb.append(topping.getName());
                    sb.append("#");
                }
                writer.write(sb.toString());
                writer.newLine();
            }
        }
    }
}
