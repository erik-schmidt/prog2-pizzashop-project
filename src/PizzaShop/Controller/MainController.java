package PizzaShop.Controller;

import PizzaShop.Exceptions.CustomerException;
import PizzaShop.Exceptions.PizzaException;
import PizzaShop.Model.*;
import PizzaShop.View.*;

import javax.swing.*;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Objects represents a controller.
 * MainController is defined with:
 * pizza shop (main frame), pizza panel.
 */
public class MainController {

    private MyPizzaShop myPizzaShop;
    private Customer customer;
    private CustomerPanel customerPanel;
    private CustomerService customerService;
    private ContactDetails contactDetails;
    private Adress adress;
    private CustomerListPanel customerListPanel;
    private PizzaPanel pizzaPanel;
    private PizzaService pizzaService;
    private Pizza pizza;
    private PizzaListPanel pizzaListPanel;
    private OpenDialog openDialog;


    /**
     * Sets the whole UI and adds actions to the menubar items.
     */
    public MainController() {
        myPizzaShop = new MyPizzaShop();
        customerService = new CustomerService();
        pizzaService = new PizzaService();
        openDialog = new OpenDialog();

        myPizzaShop.getMyMenuBar().addActionQuit(e -> {
            String[] options = {"Ja", "Nein"};
            int answer = JOptionPane.showOptionDialog(null, "Möchten Sie wirklich beenden?", "Beenden", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(answer == JOptionPane.YES_OPTION){
                try {
                    myPizzaShop.setMyPath(openDialog.saveFile());
                    customerService.saveAll(customerService.getCustomers(), null);
                    pizzaService.saveAll(pizzaService.getPizzas(), myPizzaShop.getMyPath());
                    System.exit(0);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        myPizzaShop.getMyMenuBar().addActionPizzaConfig(e -> myPizzaShop.setCenterPanel(createPizzaPanel()));
        myPizzaShop.getMyMenuBar().addActionCustomerConfig(e -> myPizzaShop.setCenterPanel(createCustomerPanel()));
        myPizzaShop.getMyMenuBar().addActionCustomerList(e -> myPizzaShop.setCenterPanel(createCustomerListPanel()));
        myPizzaShop.getMyMenuBar().addActionPizzaList(e -> myPizzaShop.setCenterPanel(createPizzaListPanel()));
        myPizzaShop.getMyMenuBar().addActionOpen(e -> {
            myPizzaShop.setMyPath(openDialog.callOpenFileDialog());
            try {
                customerService.getAll(myPizzaShop.getMyPath());
                pizzaService.getAll(myPizzaShop.getMyPath());
            } catch (IOException | CustomerException | PizzaException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

    }


    /**
     * Creates a {@see Customer}
     * @return customer
     * @throws CustomerException if something fields are empty
     */
    public Customer generateCustomer() throws CustomerException {
        customer = new Customer();
        customer.setName(customerPanel.getName());
        customer.setPrename(customerPanel.getPrename());
        customer.setGender(customerPanel.getGender());
        try {
            customer.setBirthday(customerPanel.getBirthday());
        } catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Das Datum ist nicht richtig angegeben, bitte korrigieren Sie es.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        contactDetails = new ContactDetails();
        contactDetails.setPhonenumber(customerPanel.getPhone());
        contactDetails.setMobile(customerPanel.getMobile());
        contactDetails.setMail(customerPanel.getMail());
        customer.setContactDetails(contactDetails);
        adress = new Adress();
        adress.setStreet(customerPanel.getStreet());
        adress.setHousenumber(customerPanel.getHousenumber());
        try {
            adress.setPostcode(customerPanel.getPostcode());
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Postleitzahl sollte nur aus Zahlen bestehen", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        adress.setPlace(customerPanel.getPlace());
        customer.setAdress(adress);
        return customer;
    }

    /**
     * Resets the customer panel to its original state
     */
    public void resetCustomerPanel(){
        customerPanel.getNameField().setText("");
        customerPanel.getPrenameField().setText("");
        customerPanel.getGenderBox().setSelectedIndex(0);
        customerPanel.getBirthdayField().setText("");
        customerPanel.getPhoneField().setText("");
        customerPanel.getMobileField().setText("");
        customerPanel.getMailField().setText("");
        customerPanel.getStreetField().setText("");
        customerPanel.getPostcodeField().setText("");
        customerPanel.getHousenumberField().setText("");
        customerPanel.getPlaceField().setText("");
    }

    /**
     * Creates customer configuration panel
     * @return customerPanel
     */
    public CustomerPanel createCustomerPanel(){
        customerPanel = new CustomerPanel();
        customerPanel.addActionSave(e -> {
            try {
                customerService.create(generateCustomer());
            } catch (CustomerException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        customerPanel.addActionReset(e -> resetCustomerPanel());
        return customerPanel;
    }

    /**
     * Creates a panel with list of customers.
     * @return customerListPanel
     */
    public CustomerListPanel createCustomerListPanel(){
        customerListPanel = new CustomerListPanel();
        customerListPanel.setCustomerJList(customerService.setCustomerDefaultListModel());
        customerListPanel.addActionShow(e -> JOptionPane.showMessageDialog(null, customerListPanel.getCustomerJList().getSelectedValue(),"ID: " + customerListPanel.getCustomerJList().getSelectedValue().getId(), JOptionPane.INFORMATION_MESSAGE));
        customerListPanel.addActionDelete(e -> {
            String[] options = {"Ja", "Nein"};
            int n = JOptionPane.showOptionDialog(null, "Möchten Sie wirklich den ausgewählten Kunden löschen?", "Löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
            if(n == JOptionPane.YES_OPTION) {
                customerService.delete(customerListPanel.getCustomerJList().getSelectedValue());
                customerListPanel.refreshCustomerJList(customerService.setCustomerDefaultListModel());
            }
        });
        customerListPanel.addActionSave(e -> {
            try {
                myPizzaShop.setMyPath(openDialog.saveFile());
                customerService.saveAll(customerService.getCustomers(), myPizzaShop.getMyPath());
                JOptionPane.showMessageDialog(null, "Speichern war erfolgreich!", "Speichern", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        customerListPanel.addActionEdit(e -> myPizzaShop.setCenterPanel(updateCustomerPanel()));
        customerListPanel.addActionPrint(e -> System.out.println(customerListPanel.getCustomerJList().getSelectedValue()));
        return customerListPanel;
    }

    /**
     * Customer panel to update a customer. Fields are already filled with selected customer from the customer list.
     * @return customer panel
     */
    public CustomerPanel updateCustomerPanel(){
        customerPanel = new CustomerPanel();
        customerPanel.getNameField().setText(customerListPanel.getCustomerJList().getSelectedValue().getName());
        customerPanel.getPrenameField().setText(customerListPanel.getCustomerJList().getSelectedValue().getPrename());
        customerPanel.getGenderBox().setSelectedIndex(0);
        customerPanel.getBirthdayField().setText(customerListPanel.getCustomerJList().getSelectedValue().getBirthday().toString());
        customerPanel.getPhoneField().setText(customerListPanel.getCustomerJList().getSelectedValue().getContactDetails().getPhonenumber());
        customerPanel.getMobileField().setText(customerListPanel.getCustomerJList().getSelectedValue().getContactDetails().getMobile());
        customerPanel.getMailField().setText(customerListPanel.getCustomerJList().getSelectedValue().getContactDetails().getMail());
        customerPanel.getStreetField().setText(customerListPanel.getCustomerJList().getSelectedValue().getAdress().getStreet());
        customerPanel.getHousenumberField().setText(String.valueOf(customerListPanel.getCustomerJList().getSelectedValue().getAdress().getHousenumber()));
        customerPanel.getPostcodeField().setText(String.valueOf(customerListPanel.getCustomerJList().getSelectedValue().getAdress().getPostcode()));
        customerPanel.getPlaceField().setText(customerListPanel.getCustomerJList().getSelectedValue().getAdress().getPlace());
        customerPanel.addActionSave(e -> {
            try {
                customerService.update(customerListPanel.getCustomerJList().getSelectedValue(), generateCustomer());
            } catch (CustomerException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        customerPanel.addActionReset(e -> resetCustomerPanel());
        return customerPanel;
    }

    /**
     * creates the Pizza configuration panel.
     * @return pizza panel
     */
    public PizzaPanel createPizzaPanel(){
        pizzaPanel = new PizzaPanel();
        pizzaPanel.setToppingJList(pizzaService.setToppingDefaultListModel());
        pizzaPanel.setSizeJList(pizzaService.setSizeDefaultListModel());
        pizzaPanel.addActionPrint(e -> {
            try {
                System.out.println(generatePizza());;
            } catch (PizzaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        pizzaPanel.addActionCalculate(e -> {
            try {
                pizzaPanel.setPriceTag(generatePizza().totalPrice());
            } catch (PizzaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        pizzaPanel.addActionReset(e -> resetPizzaPanel());
        pizzaPanel.addActionSave(e -> {
            try {
                pizzaService.create(generatePizza());
            } catch (PizzaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        return pizzaPanel;
    }

    /**
     * Resets the Pizza Panel to its original state
     */
    public void resetPizzaPanel(){
        pizzaPanel.getNameField().setText("");
        pizzaPanel.getToppingJList().setSelectedIndex(0);
        pizzaPanel.getSizeJList().setSelectedIndex(0);
        pizzaPanel.getPriceTag().setText("0");
    }

    public PizzaListPanel createPizzaListPanel() {
        pizzaListPanel = new PizzaListPanel();
        pizzaListPanel.setPizzaJList(pizzaService.setPizzaDefaultListModel());
        pizzaListPanel.addActionEdit(e -> myPizzaShop.setCenterPanel(updatePizzaPanel()));
        pizzaListPanel.addActionShow(e -> JOptionPane.showMessageDialog(null, pizzaListPanel.getPizzaJList().getSelectedValue(), "ID: " + pizzaListPanel.getPizzaJList().getSelectedValue().getID(), JOptionPane.INFORMATION_MESSAGE));
        pizzaListPanel.addActionDelete(e -> {
            String[] options = {"Ja", "Nein"};
            int answer = JOptionPane.showOptionDialog(null, "Möchten Sie wirklich diese Pizza löschen?", "Löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(answer == JOptionPane.YES_OPTION){
                pizzaService.delete(pizzaListPanel.getPizzaJList().getSelectedValue());
                pizzaListPanel.refreshPizzaJList(pizzaService.setPizzaDefaultListModel());
            }
        });
        pizzaListPanel.addActionSave(e -> {
            try {
                myPizzaShop.setMyPath(openDialog.saveFile());
                pizzaService.saveAll(pizzaService.getPizzas(), myPizzaShop.getMyPath());
                JOptionPane.showMessageDialog(null, "Speichern war erfolgreich!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        return pizzaListPanel;
    }

    /**
     * Creates Pizza configuration panel with already filled in fields from selected pizza {@see PizzaListPanel}
     * @return
     */
    public PizzaPanel updatePizzaPanel(){
        pizzaPanel = new PizzaPanel();
        pizzaPanel.setSizeJList(pizzaService.setSizeDefaultListModel());
        pizzaPanel.setToppingJList(pizzaService.setToppingDefaultListModel());
        pizzaPanel.getNameField().setText(pizzaListPanel.getPizzaJList().getSelectedValue().getName());
        pizzaPanel.getSizeJList().setSelectedIndex(pizzaListPanel.getPizzaJList().getSelectedValue().getPizzaSize().ordinal());
        int[] selectedToppings = new int[Topping.values().length];
        for(Topping topping : Topping.values()){
            for(int i = 0; i < pizzaListPanel.getPizzaJList().getSelectedValue().getToppings().size(); i++){
                if(topping.equals(pizzaListPanel.getPizzaJList().getSelectedValue().getToppings().get(i))){
                    selectedToppings[i] = i;
                }
            }
        }
        pizzaPanel.getToppingJList().setSelectedIndices(selectedToppings);
        pizzaPanel.getPriceTag().setText(String.valueOf(pizzaListPanel.getPizzaJList().getSelectedValue().totalPrice()));
        pizzaPanel.addActionSave(e -> {
            try {
                pizzaService.update(pizzaListPanel.getPizzaJList().getSelectedValue(), generatePizza());
            } catch (PizzaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        pizzaPanel.addActionReset(e -> resetPizzaPanel());
        pizzaPanel.addActionPrint(e -> System.out.println(pizza.toString()));
        pizzaPanel.addActionCalculate(e -> {
            try {
                pizzaPanel.setPriceTag(generatePizza().totalPrice());
            } catch (PizzaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        return pizzaPanel;
    }

    /**
     * Creates the pizza with entered fields from pizza configuration panel.
     * @return pizza
     * @throws PizzaException if name field is empty, size and/or toppings aren't selected
     */
    public Pizza generatePizza() throws PizzaException {
        pizza = new Pizza();
        pizza.setName(pizzaPanel.getName());
        for(PizzaSize pizzaSize : PizzaSize.values()){
            if(pizzaPanel.getPizzaSize().equals(pizzaSize.getName())){
                pizza.setPizzaSize(pizzaSize);
            }
        }
        for(Topping topping : Topping.values()){
            if(pizzaPanel.getTopping().contains(topping.getName())){
                pizza.addTopping(topping);
            }
        }
        pizza.totalPrice();
        return pizza;
    }

    public Locale getLocale(){
        return myPizzaShop.getLanguagePanel().getLanguageBox().getItemAt(myPizzaShop.getLanguagePanel().getLanguageBox().getSelectedIndex());
}
