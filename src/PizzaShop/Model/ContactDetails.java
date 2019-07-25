package PizzaShop.Model;

import PizzaShop.Exceptions.CustomerException;

/**
 * This Object represents Contactdetails
 * Contactdetails are defined by:
 * phonenumber, mobile and mail
 */
public class ContactDetails {

    private int id;
    private String phonenumber;
    private String mobile;
    private String mail;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id for reference to {@see customer}
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Set phonenumber
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) throws CustomerException {
        if(phonenumber != null && phonenumber.matches("\\d*")) {
            this.phonenumber = phonenumber;
        } else {
            throw new CustomerException("Telefonnummer sollte nur aus 11 Zahlen bestehen.");
        }
    }

    /**
     * @return mobile number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set mobile number
     * @param mobile
     */
    public void setMobile(String mobile) throws CustomerException {
        if(mobile != null && mobile.matches("\\d*")) {
            this.mobile = mobile;
        } else {
            throw new CustomerException("Mobil sollte nur aus 12 Zahlen bestehen");
        }
    }

    /**
     * @return e-mail adress
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set e-mail adress
     * @param mail
     */
    public void setMail(String mail) throws CustomerException {
        if(mail != null && mail.contains("@")) {
            this.mail = mail;
        } else {
            throw new CustomerException("E-Mail sollte ein @ beinhalten");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Telefonnummer: ").append(phonenumber);
        sb.append(" Mobil: ").append(mobile);
        sb.append(" E-Mail: ").append(mail);
        return sb.toString();
    }
}
