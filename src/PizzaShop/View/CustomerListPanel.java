package PizzaShop.View;

import PizzaShop.Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This Object represents a Panel with Customers in a List.
 * Customer List Panel is represented by:
 * Show Button, Edit Button, Delete Button and List of Customers.
 */
public class CustomerListPanel extends JPanel {

    private JButton showButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton printButton;
    private JButton saveButton;
    private JList<Customer> customerJList;

    /**
     * Creates the panel with the List and its buttons.
     */
    public CustomerListPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(700,500));

        showButton = new JButton("anzeigen");
        this.add(showButton, Util.makegbc(1,0,1,1));

        editButton = new JButton("ändern");
        this.add(editButton, Util.makegbc(1,1,1,1));

        deleteButton = new JButton("löschen");
        this.add(deleteButton, Util.makegbc(1,2,1,1));

        saveButton = new JButton("speichern");
        this.add(saveButton, Util.makegbc(1,3,1,1));

        printButton = new JButton("durcken");
        this.add(printButton, Util.makegbc(1,4,1,1));
    }

    /**
     * Creates the List of Customers.
     * @param customerDefaultListModel list model with customers in it.
     */
    public void setCustomerJList(DefaultListModel<Customer> customerDefaultListModel){
        customerJList = new JList<>(customerDefaultListModel);
        customerJList.setSelectedIndex(0);
        customerJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customerJList.setVisibleRowCount(customerDefaultListModel.size() - 2);
        JScrollPane customerScrollPane = new JScrollPane(customerJList);
        GridBagConstraints gbc = Util.makegbc(0,0,1,2);
        gbc.fill = GridBagConstraints.BOTH;
        this.add(customerScrollPane, gbc);
    }

    /**
     * @return show button
     */
    public JButton getShowButton() {
        return showButton;
    }

    /**
     * Adds action to the show button.
     * @param al
     */
    public void addActionShow(ActionListener al){
        showButton.addActionListener(al);
    }

    /**
     * @return edit button
     */
    public JButton getEditButton() {
        return editButton;
    }

    /**
     * Adds action to edit button
     * @param al
     */
    public void addActionEdit(ActionListener al){
        editButton.addActionListener(al);
    }

    /**
     * @return delete button
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * Adds action to delete button
     * @param al
     */
    public void addActionDelete(ActionListener al){
        deleteButton.addActionListener(al);
    }

    /**
     * @return printButton
     */
    public JButton getPrintButton(){
        return printButton;
    }

    /**
     * Adds action to print button.
     * @param al
     */
    public void addActionPrint(ActionListener al){
        printButton.addActionListener(al);
    }

    /**
     * @return save button
     */
    public JButton getSaveButton(){
        return saveButton;
    }

    /**
     * Adds action to save button
     * @param al
     */
    public void addActionSave(ActionListener al){
        saveButton.addActionListener(al);
    }

    /**
     * @return list of customers
     */
    public JList<Customer> getCustomerJList() {
        return customerJList;
    }

    public void refreshCustomerJList(DefaultListModel<Customer> customerDefaultListModel){
        customerJList.setModel(customerDefaultListModel);
    }
}
