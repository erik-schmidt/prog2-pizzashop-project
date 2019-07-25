package PizzaShop.IO;

import PizzaShop.Exceptions.CustomerException;
import PizzaShop.Model.Adress;
import PizzaShop.Model.ContactDetails;
import PizzaShop.Model.Customer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This Object represents an Input-Output Handler.
 */
public class CustomerIOHandler {

    /**
     * Reads a given file by its name.
     * @param path
     * @return list of customers
     * @throws IOException
     * @throws CustomerException if some customer informations are wrong
     */
    public List<Customer> read(String path) throws IOException, CustomerException {
        Path sourcepath = Paths.get(path);
        List<Customer> customers = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(sourcepath)){
            String line;
            while((line = reader.readLine()) != null){
                Customer customer = new Customer();
                String[] c = line.split("#");
                customer.setId(Integer.parseInt(c[0]));
                customer.setName(c[1]);
                customer.setPrename(c[2]);
                customer.setGender(c[3]);
                customer.setBirthday(LocalDate.parse(c[4]));
                ContactDetails contactDetails = new ContactDetails();
                contactDetails.setPhonenumber(c[5]);
                contactDetails.setMobile(c[6]);
                contactDetails.setMail(c[7]);
                customer.setContactDetails(contactDetails);
                Adress adress = new Adress();
                adress.setStreet(c[8]);
                adress.setHousenumber(Integer.parseInt(c[9]));
                adress.setPostcode(Integer.parseInt(c[10]));
                adress.setPlace(c[11]);
                customer.setAdress(adress);
                customers.add(customer);
            }
        }
        return customers;
    }

    /**
     * Writes a text file with given name as filename.
     * @param customers
     * @param path
     * @throws IOException
     */
    public void write(List<Customer> customers, String path) throws IOException {
        Path destination = Paths.get(path);
        try(BufferedWriter writer = Files.newBufferedWriter(destination)){
            String line;
            for(Customer customer : customers){
                StringBuilder sb = new StringBuilder();
                sb.append(customer.getId());
                sb.append("#");
                sb.append(customer.getName());
                sb.append("#");
                sb.append(customer.getPrename());
                sb.append("#");
                sb.append(customer.getGender());
                sb.append("#");
                sb.append(customer.getBirthday());
                sb.append("#");
                sb.append(customer.getContactDetails().getPhonenumber());
                sb.append("#");
                sb.append(customer.getContactDetails().getMobile());
                sb.append("#");
                sb.append(customer.getContactDetails().getMail());
                sb.append("#");
                sb.append(customer.getAdress().getStreet());
                sb.append("#");
                sb.append(customer.getAdress().getHousenumber());
                sb.append("#");
                sb.append(customer.getAdress().getPostcode());
                sb.append("#");
                sb.append(customer.getAdress().getPlace());
                writer.write(sb.toString());
                writer.newLine();
            }
        }
    }
}
