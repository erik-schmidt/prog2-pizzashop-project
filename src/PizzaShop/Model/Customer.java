package PizzaShop.Model;

import PizzaShop.Exceptions.CustomerException;

import java.time.LocalDate;

/**
 * This Object represents a Customer.
 * Customer is defined by:
 * ID, name, prename, gender, birthday, contactdetails {@see ContactDetails}, adress {@see Adress}
 */
public class Customer {

    private int id;
    private String name;
    private String prename;
    private String gender;
    private LocalDate birthday;
    private ContactDetails contactDetails;
    private Adress adress;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id for customer
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name of customer
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for customer
     * @param name
     */
    public void setName(String name) throws CustomerException {
        if(name != null && name.matches("\\D*")) {
            this.name = name;
        } else {
            throw new CustomerException("Name muss aus Buchstaben bestehen");
        }
    }

    /**
     * @return prename of customer
     */
    public String getPrename() {
        return prename;
    }

    /**
     * Set prename of customer
     * @param prename
     */
    public void setPrename(String prename) throws CustomerException {
        if(prename != null && prename.matches("\\D*")) {
            this.prename = prename;
        } else {
            throw new CustomerException("Vorname sollte nur aus Buchstaben bestehen");
        }
    }

    /**
     * @return gender of customer
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set gender for customer
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return birthday of customer
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set birthday of customer
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * @return {@see ContactDetails} of customer
     */
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the {@see ContactDetails} of customer
     * @param contactDetails
     */
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * @return {@see Adress} of customer
     */
    public Adress getAdress() {
        return adress;
    }

    /**
     * Sets {@see Adress} of customer
     * @param adress
     */
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id);
        sb.append(" Name: ").append(name);
        sb.append(" Vorname: ").append(prename);
        sb.append(" Geschlecht: ").append(gender);
        sb.append(" Geburtstag: ").append(birthday);
        sb.append(" Kontaktdaten: ").append(contactDetails);
        sb.append(" Adresse: ").append(adress);
        return sb.toString();
    }
}
