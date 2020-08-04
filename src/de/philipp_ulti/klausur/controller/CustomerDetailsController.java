package de.philipp_ulti.klausur.controller;

import de.philipp_ulti.klausur.model.logic.Customer;
import de.philipp_ulti.klausur.view.CustomerDetailsPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CustomerDetailsController implements ListSelectionListener {

    private CustomerDetailsPanel view;

    public CustomerDetailsController(CustomerDetailsPanel view) {
        this.view = view;
    }

    /**
     * overwriting the value changed method to get the current selection
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Customer current = view.getCustomersInTheSystem().getSelectedValue();
        this.view.getCustomerDetails().setText("Name: " + current.getName() + System.lineSeparator() + "Customer-ID: " + current.getCustomerId());
        if(this.view.getCustomersInTheSystem().getSelectedValue() == null) {
            this.view.getCustomerDetails().setText("Name: " + this.view.getCustomersInTheSystem().getModel().getElementAt(0).getName() + System.lineSeparator() + "Customer-ID:" + this.view.getCustomersInTheSystem().getModel().getElementAt(0).getName());
        }
    }
}
