package PizzaShop.Model;

import PizzaShop.Exceptions.CustomerException;

/**
 * This Object represents an Adress Object.
 * Adress is defined by:
 * ID, street, housenumber, postcode, place
 */

public class Adress {

    private int id;
    private String street;
    private int housenumber;
    private int postcode;
    private String place;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id for adress object
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return streetname
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street name
     * @param street
     */
    public void setStreet(String street) throws CustomerException {
        if(street != null && street.trim().matches("\\D*\\s?")) {
            this.street = street;
        } else {
            throw new CustomerException("Straße darf nur aus Buchstaben bestehen.");
        }
    }

    /**
     * @return housenumber
     */
    public int getHousenumber() {
        return housenumber;
    }

    /**
     * Sets the house number for adress
     * @param housenumber
     */
    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    /**
     * @return postcode
     */
    public int getPostcode() {
        return postcode;
    }

    /**
     * Sets postcode for adress
     * @param postcode
     */
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    /**
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets place
     * @param place
     */
    public void setPlace(String place) throws CustomerException {
        if(place != null && place.matches("\\D*\\s?")) {
            this.place = place;
        } else {
            throw new CustomerException("Ort darf nur aus Buchstaben bestehen");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Straße : ").append(street);
        sb.append(" Hausnummer: ").append(housenumber);
        sb.append(" Postleitzahl: ").append(postcode);
        sb.append(" Ort: ").append(place);
        return sb.toString();
    }
}
