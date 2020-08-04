package de.philipp_ulti.klausur.model.logic;

import de.philipp_ulti.klausur.model.io.LoadCustomers;
import de.philipp_ulti.klausur.model.io.RemoveCustomers;
import de.philipp_ulti.klausur.model.io.StoreCustomers;
import de.philipp_ulti.klausur.model.visitorInterfaces.Visitable;
import de.philipp_ulti.klausur.model.visitorInterfaces.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CustomerSystem extends Observable implements Visitable<Customer> {

    private List<Customer> customers;

    public CustomerSystem() {
        customers = new ArrayList<>();
        customers = LoadCustomers.loadAllCustomersFromDisk();
        for (Customer customer : customers) {
            System.out.println(customer.getCustomerId());
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * überarbeiten (muss concurrent sein!)
     * @param toAdd
     * @return
     */
    public boolean addCustomer(Customer toAdd) {
        for (Customer customer : customers) {
            if(customer.equals(toAdd)) {
                return false;
            }
        }
        customers.add(toAdd);
        StoreCustomers.storeCustomerOnDisk(toAdd);
        this.setChanged();
        this.notifyObservers();
        return true;
    }

    public void removeCustomer(Customer toRemove) {
        if(customers.contains(toRemove)) {
            customers.remove(toRemove);
            RemoveCustomers.removeCustomerFromDisk(toRemove.getCustomerId());
            this.setChanged();
            this.notifyObservers();
        }
    }

    /**
     * method to accept a visitor
     * @param v
     *           the Visitor which should be called for every element in this
     */
    @Override
    public void accept(Visitor<Customer> v) {
        for (Customer customer : customers) {
            v.visit(customer);
        }
    }
}
