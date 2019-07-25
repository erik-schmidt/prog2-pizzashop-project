package PizzaShop.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Object represents a Pizza configuration Panel.
 * PizzaPanel is defined with attributes:
 * name Label, Name Textfield, Topping Label, Topping List, Size Label, Size List, Send Button, Print Button,
 * price Label and Price Tag.
 */

public class PizzaPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel sizeLabel;
    private JLabel toppingLabel;
    private JLabel priceLabel;
    private JLabel priceTag;
    private JButton sendButton;
    private JButton printButton;
    private JButton calculateButton;
    private JButton resetButton;
    private JButton saveButton;
    private JList<String> sizeJList;
    private JList<String> toppingJList;

    /**
     * Creates the Pizza Panel
     */
    public PizzaPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,500));
        setMaximumSize(new Dimension(800,500));

        nameLabel = new JLabel("Name:");
        this.add(nameLabel, Util.makegbc(0,0,1,1));

        nameField = new JTextField(10);
        this.add(nameField, Util.makegbc(1,0,1,1));

        sizeLabel = new JLabel("Größe:");
        this.add(sizeLabel, Util.makegbc(0,1,1,1));

        toppingLabel = new JLabel("Belag:");
        this.add(toppingLabel, Util.makegbc(0,2,1,1));

        priceLabel = new JLabel("Preis:");
        this.add(priceLabel, Util.makegbc(0,3,1,1));

        priceTag = new JLabel("");
        this.add(priceTag, Util.makegbc(1,3,1,1));

        sendButton = new JButton("abschicken");
        this.add(sendButton, Util.makegbc(0,4,1,1));

        printButton = new JButton("ausdrucken");
        this.add(printButton, Util.makegbc(1,4,1,1));

        calculateButton = new JButton("Preis berechnen");
        this.add(calculateButton, Util.makegbc(2,4,1,1));

        resetButton = new JButton("zurücksetzen");
        this.add(resetButton, Util.makegbc(1,5,1,1));

        saveButton = new JButton("speichern");
        this.add(saveButton, Util.makegbc(0,5,1,1));
    }

    /**
     * Creates the Size List in the Panel
     * @param sizeListModel
     */
    public void setSizeJList(DefaultListModel sizeListModel){
        sizeJList = new JList<>(sizeListModel);
        sizeJList.setSelectedIndex(0);
        sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizeJList.setVisibleRowCount(sizeListModel.size() - 2);
        JScrollPane sizeScrollPane = new JScrollPane(sizeJList);
        this.add(sizeScrollPane, Util.makegbc(1,1,1,1));
    }

    /**
     * Creates the Topping List for the Panel
     * @param toppingListModel
     */
    public void setToppingJList(DefaultListModel toppingListModel){
        toppingJList = new JList<>(toppingListModel);
        toppingJList.setVisibleRowCount(toppingListModel.size() - 2);
        toppingJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        toppingJList.setSelectedIndex(0);
        JScrollPane toppingScrollPane = new JScrollPane(toppingJList);
        this.add(toppingScrollPane, Util.makegbc(1,2,1,1));
    }

    /**
     * @return Name Textfield
     */
    public JTextField getNameField(){
        return nameField;
    }

    /**
     * @return Size List
     */
    public JList getSizeJList(){
        return sizeJList;
    }

    /**
     * @return Topping List
     */
    public JList getToppingJList(){
        return toppingJList;
    }

    /**
     * Sets action for send button
     * @param al
     */
    public void addActionSend(ActionListener al){
        sendButton.addActionListener(al);
    }

    /**
     * Sets action for print button
     * @param al
     */
    public void addActionPrint(ActionListener al){
        printButton.addActionListener(al);
    }

    /**
     * Sets action for Calculate Button.
     * @param al
     */
    public void addActionCalculate(ActionListener al){
        calculateButton.addActionListener(al);
    }

    /**
     * @return text of name textfield
     */
    public String getName(){
        return nameField.getText();
    }

    public JLabel getPriceTag(){
        return priceTag;
    }

    /**
     * @return Selected pizza size
     */
    public String getPizzaSize(){
        return sizeJList.getSelectedValue();
    }

    /**
     * @return List of selected toppings
     */
    public List<String> getTopping(){
        return toppingJList.getSelectedValuesList();
    }

    /**
     * Sets the price tag
     * @param price
     */
    public void setPriceTag(int price){
        priceTag.setText("" + price);
    }

    public void addActionReset(ActionListener al){
        resetButton.addActionListener(al);
    }

    public void addActionSave(ActionListener al){
        saveButton.addActionListener(al);
    }
}
