package de.philipp_ulti.klausur.view;

import de.philipp_ulti.klausur.controller.AddCustomerController;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomerPanel extends JPanel {

    private CustomerSystem model;
    private JLabel nameLabel;
    private JLabel customerIdLabel;
    private JTextField nameInput;
    private JTextField customerIdInput;
    private JButton addCustomer;

    public AddCustomerPanel(CustomerSystem model) {
        this.model = model;
        nameLabel = new JLabel("Name");
        customerIdLabel = new JLabel("Customer-ID");
        nameInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(179, 79));
        customerIdInput = new JTextField();
        customerIdInput.setPreferredSize(new Dimension(179, 79));
        addCustomer = new JButton();
        addCustomer.setText("Add Customer");
        addCustomer.addActionListener(new AddCustomerController(this.model, this));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(nameLabel);
        this.add(nameInput);
        this.add(customerIdLabel);
        this.add(customerIdInput);
        this.add(addCustomer);
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public JTextField getCustomerIdInput() {
        return customerIdInput;
    }

    public JButton getAddCustomer() {
        return addCustomer;
    }
}
