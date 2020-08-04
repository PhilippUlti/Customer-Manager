package de.philipp_ulti.klausur.view;

import de.philipp_ulti.klausur.controller.CustomerDetailsController;
import de.philipp_ulti.klausur.model.logic.Customer;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CustomerDetailsPanel extends JPanel implements Observer {

    private CustomerSystem model;
    private JList<Customer> customersInTheSystem;
    private JScrollPane customersInTheSystemScrollPane;
    private JTextArea customerDetails;

    public CustomerDetailsPanel(CustomerSystem model) {
        model.addObserver(this);
        this.model = model;
        customersInTheSystem = new JList<Customer>();
        DefaultListModel<Customer> listModel = new DefaultListModel<>();
        for (Customer customer : this.model.getCustomers()) {
            listModel.addElement(customer);
        }
        customersInTheSystem.setModel(listModel);
        customersInTheSystemScrollPane = new JScrollPane();
        customersInTheSystemScrollPane.add(customersInTheSystem);
        customerDetails = new JTextArea();
        customerDetails.setPreferredSize(new Dimension(179,79));
        customerDetails.setEnabled(false);
        if(model.getCustomers().size() >= 1) {
            customerDetails.setText("Name: " + this.model.getCustomers().get(0).getName() + System.lineSeparator() + "Customer-ID: " + this.model.getCustomers().get(0).getCustomerId());
        }
        customersInTheSystem.addListSelectionListener(new CustomerDetailsController(this));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(customersInTheSystemScrollPane);
        this.add(customersInTheSystem);
        this.add(customerDetails);
    }

    public JTextArea getCustomerDetails() {
        return customerDetails;
    }

    public JList<Customer> getCustomersInTheSystem() {
        return customersInTheSystem;
    }

    public void updateCustomerList() {
        DefaultListModel<Customer> listModel = new DefaultListModel<>();
        for (Customer customer : this.model.getCustomers()) {
            listModel.addElement(customer);
        }
        customersInTheSystem.setModel(listModel);
    }

    @Override
    public void update(Observable o, Object arg) {
        updateCustomerList();
    }
}
