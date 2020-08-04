package de.philipp_ulti.klausur.controller;

import de.philipp_ulti.klausur.model.io.RemoveCustomerVisitor;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;
import de.philipp_ulti.klausur.view.RemoveCustomerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCustomerController implements ActionListener {

    private CustomerSystem model;
    private RemoveCustomerPanel view;

    public RemoveCustomerController(CustomerSystem model, RemoveCustomerPanel view) {
        this.model = model;
        this.view = view;
    }
    /**
     * overwriting the action performed method of action listener, to remove CreateFrame customer when clicking on the button!
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String customerId = this.view.getCustomerIdToRemove().getText();
        try {
            RemoveCustomerVisitor removeCustomerVisitor = new RemoveCustomerVisitor(customerId, this.model);
            model.accept(removeCustomerVisitor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame("Error!"), ex.getMessage());
        }
    }
}
