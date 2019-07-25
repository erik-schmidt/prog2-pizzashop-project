package PizzaShop.View;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Object represents a menubar
 * Menubar is defined with:
 * file menu, quit menu item, config menu, pizza config menu item
 */
public class MyMenuBar extends JMenuBar {

    private JMenu file;
    private JMenuItem quit;
    private JMenuItem open;
    private JMenu config;
    private JMenuItem pizzaConfig;
    private JMenuItem pizzaList;
    private JMenu customer;
    private JMenuItem customerConfig;
    private JMenuItem customerList;

    /**
     * Adds the Menu and Menu items in the menubar
     */
    public MyMenuBar() {
        file = new JMenu("Datei");
        quit = new JMenuItem("Beenden");
        open = new JMenuItem("Öffnen");
        file.add(open);
        file.add(quit);
        this.add(file);

        config = new JMenu("Konfigurator");
        pizzaConfig = new JMenuItem("Pizza erstellen");
        config.add(pizzaConfig);
        pizzaList = new JMenuItem("Liste der Pizzas");
        config.add(pizzaList);
        this.add(config);

        customer = new JMenu("Kunde");
        customerConfig = new JMenuItem("Kunde erstellen");
        customerList = new JMenuItem("Liste der Kunden");
        customer.add(customerConfig);
        customer.add(customerList);
        this.add(customer);
    }

    /**
     * Sets action of quit menu item
     * @param al
     */
    public void addActionQuit(ActionListener al){
        quit.addActionListener(al);
    }

    /**
     * Sets action for pizza configuration menu item
     * @param al
     */
    public void addActionPizzaConfig(ActionListener al){
        pizzaConfig.addActionListener(al);
    }

    /**
     * Sets action for customer configuration menu item
     * @param al
     */
    public void addActionCustomerConfig(ActionListener al){
        customerConfig.addActionListener(al);
    }

    /**
     * Sets action for customer list menu item
     * @param al
     */
    public void addActionCustomerList(ActionListener al){
        customerList.addActionListener(al);
    }

    /**
     * Sets action for pizza list menu item
     * @param al
     */
    public void addActionPizzaList(ActionListener al){
        pizzaList.addActionListener(al);
    }

    /**
     * Sets action for open menu item
     * @param al
     */
    public void addActionOpen(ActionListener al){
        open.addActionListener(al);
    }

    /**
     * @return file menu
     */
    public JMenu getFile() {
        return file;
    }

    /**
     * @return quit menu item
     */
    public JMenuItem getQuit() {
        return quit;
    }

    /**
     * @return open menu item
     */
    public JMenuItem getOpen() {
        return open;
    }

    /**
     * @return config menu
     */
    public JMenu getConfig() {
        return config;
    }

    /**
     * @return pizza config menu item
     */
    public JMenuItem getPizzaConfig() {
        return pizzaConfig;
    }

    /**
     * @return pizza list menu item
     */
    public JMenuItem getPizzaList() {
        return pizzaList;
    }

    /**
     * @return customers menu
     */
    public JMenu getCustomer() {
        return customer;
    }

    /**
     * @return customer config menu item
     */
    public JMenuItem getCustomerConfig() {
        return customerConfig;
    }

    /**
     * @return customer list menu item
     */
    public JMenuItem getCustomerList() {
        return customerList;
    }
}
