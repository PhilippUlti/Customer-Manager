package de.philipp_ulti.klausur.model.logic;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Customer  implements Serializable {

    private long serialVersionUID = 29;
    private String name;
    private String customerId;

    public Customer(String name, String customerId) {
        this.name = name;

        String regex = "[1-9]{4}-[A-Z]{4}";
        if(Pattern.matches(regex, customerId)) {
            this.customerId = customerId;
        } else {
            throw new IllegalArgumentException();
        }
        System.out.println(Pattern.matches(regex,customerId));
    }

    /**
     * returns the name of a customer
     * @return String name
     */
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object obj) {
        if(((Customer)obj).getCustomerId() == this.customerId) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int)this.serialVersionUID + super.hashCode();
    }
}
