package PizzaShop.Model;

import PizzaShop.Exceptions.CustomerException;
import PizzaShop.IO.CustomerIOHandler;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This Object represents a Customer service.
 * Customer service is defined by:
 * list of customers and counter for the ID.
 */
public class CustomerService {

    private List<Customer> customers;
    private static int counter;
    private DefaultListModel<Customer> customerDefaultListModel;
    private CustomerIOHandler customerIOHandler;

    /**
     * Creates list of customers and sets the counter to 0
     */
    public CustomerService() {
        this.customers = new ArrayList<>();
        counter = 0;
        customerIOHandler = new CustomerIOHandler();
    }

    /**
     * Creates Customer and sets the ID.
     * @param customer
     */
    public void create(Customer customer){
        customer.setId(counter++);
        customer.getContactDetails().setId(counter);
        customer.getAdress().setId(counter);
        customers.add(customer);
    }

    /**
     * Updates the customer to correct information or give further information
     * @param customer
     */
    public void update(Customer customer, Customer newCustomer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()) {
                customers.remove(c);
                newCustomer.setId(customer.getId());
                customers.add(newCustomer);
                break;
            }
        }
    }

    /**
     * Removes customer for the list
     * @param customer {@see Customer}
     */
    public void delete(Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                customers.remove(c);
                break;
            }
        }
    }

    /**
     * Searches for customer with given ID.
     * @param id
     * @return {@see customer}
     */
    public Customer read(int id){
        for(Customer customer : customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    /**
     * Creates List Blatt5.Model with customers in it for customer list panel.
     * @return customerDefaultListModel
     */
    public DefaultListModel<Customer> setCustomerDefaultListModel(){
        customerDefaultListModel = new DefaultListModel<>();
        for(Customer customer : customers){
            customerDefaultListModel.addElement(customer);
        }
        return customerDefaultListModel;
    }

    /**
     * @return list of customers from given file
     */
    public List<Customer> getAll(String path) throws IOException, CustomerException {
        customers = new ArrayList<>(customerIOHandler.read(path));
        return customerIOHandler.read(path);
    }

    /**
     * @return list of customers
     */
    public List<Customer> getCustomers(){
        return new ArrayList<>(customers);
    }

    /**
     * Saves all customers from a list into a file.
     * @param customers
     * @param path
     * @throws IOException
     */
    public void saveAll(List<Customer> customers, String path) throws IOException {
        customerIOHandler.write(customers, path);
    }
}
