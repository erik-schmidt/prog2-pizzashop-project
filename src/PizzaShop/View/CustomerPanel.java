package PizzaShop.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class CustomerPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel prenameLabel;
    private JTextField prenameField;
    private JLabel genderLabel;
    private JComboBox<String> genderBox;
    private JLabel birthdayLabel;
    private JTextField birthdayField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel mobileLabel;
    private JTextField mobileField;
    private JLabel mailLabel;
    private JTextField mailField;
    private JLabel streetLabel;
    private JTextField streetField;
    private JLabel housenumberLabel;
    private JTextField housenumberField;
    private JLabel postcodeLabel;
    private JTextField postcodeField;
    private JLabel placeLabel;
    private JTextField placeField;
    private JLabel contactDetailsLabel;
    private JLabel adressLabel;
    private JLabel personalLabel;
    private JButton saveButton;
    private JButton resetButton;

    public CustomerPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,500));
        setMaximumSize(new Dimension(800,500));

        personalLabel = new JLabel("Persönliche Daten");
        personalLabel.setFont(personalLabel.getFont().deriveFont(20f));
        this.add(personalLabel, Util.makegbc(0,0,1,1));

        nameLabel = new JLabel("Name");
        this.add(nameLabel, Util.makegbc(1,0,1,1));

        nameField = new JTextField(10);
        this.add(nameField, Util.makegbc(2,0,1,1));

        prenameLabel = new JLabel("Vorname");
        this.add(prenameLabel, Util.makegbc(1,1,1,1));

        prenameField = new JTextField(10);
        this.add(prenameField, Util.makegbc(2,1,1,1));

        genderLabel = new JLabel("Geschlecht");
        this.add(genderLabel, Util.makegbc(1,2,1,1));

        genderBox = new JComboBox<>();
        genderBox.addItem("Männlich");
        genderBox.addItem("Weiblich");
        genderBox.addItem("Andere");
        this.add(genderBox, Util.makegbc(2,2,1,1));

        birthdayLabel = new JLabel("Geburtstag");
        this.add(birthdayLabel, Util.makegbc(1,3,1,1));

        birthdayField = new JTextField(10);
        this.add(birthdayField, Util.makegbc(2,3,1,1));

        contactDetailsLabel = new JLabel("Kontaktdaten");
        contactDetailsLabel.setFont(contactDetailsLabel.getFont().deriveFont(20f));
        this.add(contactDetailsLabel, Util.makegbc(0,4,1,1));

        phoneLabel = new JLabel("Telefonnummer");
        this.add(phoneLabel, Util.makegbc(1,4,1,1));

        phoneField = new JTextField(10);
        this.add(phoneField, Util.makegbc(2,4,1,1));

        mobileLabel = new JLabel("Mobil");
        this.add(mobileLabel, Util.makegbc(1,5,1,1));

        mobileField = new JTextField(10);
        this.add(mobileField, Util.makegbc(2,5,1,1));

        mailLabel = new JLabel("E-Mail");
        this.add(mailLabel, Util.makegbc(1,6,1,1));

        mailField = new JTextField(10);
        this.add(mailField, Util.makegbc(2,6,1,1));

        adressLabel = new JLabel("Adresse");
        adressLabel.setFont(adressLabel.getFont().deriveFont(20f));
        this.add(adressLabel, Util.makegbc(0,7,1,1));

        streetLabel = new JLabel("Straße");
        this.add(streetLabel, Util.makegbc(1,7,1,1));

        streetField = new JTextField(10);
        this.add(streetField, Util.makegbc(2,7,1,1));

        housenumberLabel = new JLabel("Hausnummer");
        this.add(housenumberLabel, Util.makegbc(1,8,1,1));

        housenumberField = new JTextField(10);
        this.add(housenumberField, Util.makegbc(2,8,1,1));

        postcodeLabel = new JLabel("Postleitzahl");
        this.add(postcodeLabel, Util.makegbc(1,9,1,1));

        postcodeField = new JTextField(10);
        this.add(postcodeField, Util.makegbc(2,9,1,1));

        placeLabel = new JLabel("Ort");
        this.add(placeLabel, Util.makegbc(1,10,1,1));

        placeField = new JTextField(10);
        this.add(placeField, Util.makegbc(2,10,1,1));

        saveButton = new JButton("speichern");
        this.add(saveButton, Util.makegbc(0,11,1,1));

        resetButton = new JButton("zurücksetzen");
        this.add(resetButton, Util.makegbc(2,11,1,1));
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JLabel getPrenameLabel() {
        return prenameLabel;
    }

    public JTextField getPrenameField() {
        return prenameField;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public JComboBox<String> getGenderBox() {
        return genderBox;
    }

    public JLabel getBirthdayLabel() {
        return birthdayLabel;
    }

    public JTextField getBirthdayField() {
        return birthdayField;
    }

    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JLabel getMobileLabel() {
        return mobileLabel;
    }

    public JTextField getMobileField() {
        return mobileField;
    }

    public JLabel getMailLabel() {
        return mailLabel;
    }

    public JTextField getMailField() {
        return mailField;
    }

    public JLabel getStreetLabel() {
        return streetLabel;
    }

    public JTextField getStreetField() {
        return streetField;
    }

    public JLabel getHousenumberLabel() {
        return housenumberLabel;
    }

    public JTextField getHousenumberField() {
        return housenumberField;
    }

    public JLabel getPostcodeLabel() {
        return postcodeLabel;
    }

    public JTextField getPostcodeField() {
        return postcodeField;
    }

    public JLabel getPlaceLabel() {
        return placeLabel;
    }

    public JTextField getPlaceField() {
        return placeField;
    }

    public JLabel getContactDetailsLabel() {
        return contactDetailsLabel;
    }

    public JLabel getAdressLabel() {
        return adressLabel;
    }

    public JLabel getPersonalLabel() {
        return personalLabel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public String getName(){
        return nameField.getText();
    }

    public String getPrename(){
        return prenameField.getText();
    }

    public String getGender(){
        return (String) genderBox.getSelectedItem();
    }

    public LocalDate getBirthday(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault());
        LocalDate localDate = LocalDate.parse(birthdayField.getText(), dateFormat);
        return localDate;
    }

    public String getPhone(){
        return phoneField.getText();
    }

    public String getMobile(){
        return mobileField.getText();
    }

    public String getMail(){
        return mailField.getText();
    }

    public String getStreet(){
        return streetField.getText();
    }

    public int getHousenumber(){
        return Integer.parseInt(housenumberField.getText());
    }

    public String getPlace(){
        return placeField.getText();
    }

    public int getPostcode(){
        return Integer.parseInt(postcodeField.getText());
    }

    public void addActionSave(ActionListener al){
        saveButton.addActionListener(al);
    }

    public void addActionReset(ActionListener al){
        resetButton.addActionListener(al);
    }
}
