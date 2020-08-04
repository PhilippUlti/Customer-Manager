package de.philipp_ulti.klausur.controller;

import de.philipp_ulti.klausur.model.logic.Customer;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;
import de.philipp_ulti.klausur.view.AddCustomerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerController implements ActionListener {

    private CustomerSystem model;
    private AddCustomerPanel view;

    public AddCustomerController(CustomerSystem model, AddCustomerPanel view) {
        this.model = model;
        this.view = view;
    }

    /**
     * overwriting the action performed method of action listener, to add CreateFrame customer when clicking on the button!
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name;
        String customerId;
        name = this.view.getNameInput().getText();
        customerId = this.view.getCustomerIdInput().getText();
        Customer c = new Customer(name, customerId);
        if(!this.model.addCustomer(c)) {
            JOptionPane.showMessageDialog(new JFrame("Error!"),"The customer you created has already been in the system! Please consider to create CreateFrame different one!");
        }
    }
}
