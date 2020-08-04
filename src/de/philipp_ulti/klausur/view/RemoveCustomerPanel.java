package de.philipp_ulti.klausur.view;

import de.philipp_ulti.klausur.controller.RemoveCustomerController;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;

import javax.swing.*;
import java.awt.*;

public class RemoveCustomerPanel extends JPanel {

    private CustomerSystem model;
    private JButton removeCustomer;
    private JTextField customerIdToRemove;
    private JLabel customerIdToRemoveLabel;

    public RemoveCustomerPanel(CustomerSystem model) {
        this.model = model;
        customerIdToRemoveLabel = new JLabel("Customer-ID to remove:");
        customerIdToRemove = new JTextField();
        customerIdToRemove.setPreferredSize(new Dimension(179,79));
        removeCustomer = new JButton();
        removeCustomer.setText("Remove Customer");
        removeCustomer.addActionListener(new RemoveCustomerController(this.model, this));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(customerIdToRemoveLabel);
        this.add(customerIdToRemove);
        this.add(removeCustomer);
    }

    public JTextField getCustomerIdToRemove() {
        return customerIdToRemove;
    }
}
