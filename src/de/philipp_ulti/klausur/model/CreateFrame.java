package de.philipp_ulti.klausur.model;

import de.philipp_ulti.klausur.controller.AddCustomerController;
import de.philipp_ulti.klausur.model.io.LoadCustomers;
import de.philipp_ulti.klausur.model.io.RemoveCustomers;
import de.philipp_ulti.klausur.model.io.StoreCustomers;
import de.philipp_ulti.klausur.model.logic.Customer;
import de.philipp_ulti.klausur.model.logic.CustomerSystem;
import de.philipp_ulti.klausur.model.timer.BreakAlarm;
import de.philipp_ulti.klausur.view.AddCustomerPanel;
import de.philipp_ulti.klausur.view.CustomerDetailsPanel;
import de.philipp_ulti.klausur.view.RemoveCustomerPanel;
import de.philipp_ulti.klausur.view.SystemPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class CreateFrame {

    public static void main (String args[]){
        Customer customer = new Customer("ABCD","1234-ABCD");
        CustomerSystem customerSystem = new CustomerSystem();
        StoreCustomers.storeCustomerOnDisk(customer);
        List<Customer> kunden = LoadCustomers.loadAllCustomersFromDisk();
        RemoveCustomers.removeCustomerFromDiskConcurrent(customer.getCustomerId());

        JFrame frame = new JFrame("Panel");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SystemPanel panel = new SystemPanel(customerSystem);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        BreakAlarm breakAlarm = new BreakAlarm();
        breakAlarm.begin();
    }
}
