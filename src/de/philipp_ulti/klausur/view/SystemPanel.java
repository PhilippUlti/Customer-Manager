package de.philipp_ulti.klausur.view;

import de.philipp_ulti.klausur.model.logic.CustomerSystem;

import javax.swing.*;
import java.awt.*;

public class SystemPanel extends JPanel {

    private CustomerSystem model;

    public SystemPanel(CustomerSystem model) {
        this.model = model;
        this.setLayout(new BorderLayout());
        this.add(new AddCustomerPanel(model), BorderLayout.WEST);
        this.add(new RemoveCustomerPanel(model), BorderLayout.CENTER);
        this.add(new CustomerDetailsPanel(model), BorderLayout.EAST);
    }

}
