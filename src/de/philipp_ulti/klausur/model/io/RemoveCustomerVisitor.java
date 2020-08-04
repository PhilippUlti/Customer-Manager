package de.philipp_ulti.klausur.model.io;

import de.philipp_ulti.klausur.model.logic.Customer;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;
import de.philipp_ulti.klausur.model.visitorInterfaces.Visitor;

import java.util.regex.Pattern;

public class RemoveCustomerVisitor implements Visitor<Customer> {

    private CustomerSystem customerSystem;
    private String customerToSearch;

    public RemoveCustomerVisitor(String customerIdToSearch, CustomerSystem sytemToSearch) {
        String regex = "[1-9]{4}-[A-Z]{4}";
        if(Pattern.matches(regex, customerIdToSearch)) {
            this.customerToSearch = customerIdToSearch;
            this.customerSystem = sytemToSearch;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * method to visit the customer and remove the customer also
     * @param toVisit
     * @return
     */
    @Override
    public boolean visit(Customer toVisit) {
        if(toVisit.getCustomerId().equals(customerToSearch)) {
            customerSystem.removeCustomer(toVisit);
            return false;
        } else {
            return false;
        }
    }
}
