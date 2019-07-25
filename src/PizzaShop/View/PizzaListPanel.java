package PizzaShop.View;

import PizzaShop.Model.Pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This Object represents a Panel with List of pizzas.
 * PizzaListPanel is represented by:
 * show Button, edit button, delete button, pizza list.
 */
public class PizzaListPanel extends JPanel {

    private JButton showButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JList<Pizza> pizzaJList;

    /**
     * Adds elements to the panel.
     */
    public PizzaListPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(700,500));
        setMaximumSize(new Dimension(700,500));

        showButton = new JButton("anzeigen");
        this.add(showButton, Util.makegbc(1,0,1,1));

        editButton = new JButton("ändern");
        this.add(editButton, Util.makegbc(1,1,1,1));

        deleteButton = new JButton("löschen");
        this.add(deleteButton, Util.makegbc(1,2,1,1));

        saveButton = new JButton("speichern");
        this.add(saveButton, Util.makegbc(1,3,1,1));

    }

    /**
     * Sets the list of pizzas for ui.
     * @param pizzaDefaultListModel
     */
    public void setPizzaJList(DefaultListModel<Pizza> pizzaDefaultListModel){
        pizzaJList = new JList<>(pizzaDefaultListModel);
        pizzaJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pizzaJList.setSelectedIndex(0);
        pizzaJList.setVisibleRowCount(pizzaDefaultListModel.size() - 2);
        JScrollPane pizzaScrollPane = new JScrollPane(pizzaJList);
        GridBagConstraints gbc = Util.makegbc(0,1,1,1);
        gbc.fill = GridBagConstraints.BOTH;
        this.add(pizzaScrollPane, gbc);
    }

    /**
     * @return show button
     */
    public JButton getShowButton() {
        return showButton;
    }

    /**
     * Adds action to show button
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
     * Adds action to Edit button
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
     * Adds action to the delete button
     * @param al
     */
    public void addActionDelete(ActionListener al){
        deleteButton.addActionListener(al);
    }

    /**
     * @return save button
     */
    public JButton getSaveButton(){
        return saveButton;
    }

    /**
     * Adds Action to save button
     * @param al
     */
    public void addActionSave(ActionListener al){
        saveButton.addActionListener(al);
    }

    /**
     * @return pizza list
     */
    public JList<Pizza> getPizzaJList() {
        return pizzaJList;
    }

    /**
     * Refreshes the pizza list
     * @param pizzaDefaultListModel
     */
    public void refreshPizzaJList(DefaultListModel<Pizza> pizzaDefaultListModel){
        pizzaJList.setModel(pizzaDefaultListModel);
    }
}
