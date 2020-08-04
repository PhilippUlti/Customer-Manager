package de.philipp_ulti.klausur.model.io;

import de.philipp_ulti.klausur.model.logic.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadCustomers {

    public static Customer loadCustomerFromDisk(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            final Customer customer = (Customer) objectInputStream.readObject();
            return customer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method to load all customers from the disk
     * @return
     */
    public static List<Customer> loadAllCustomersFromDisk() {

        List<Customer> list = new ArrayList<Customer>();

        //das Codesnippet mit integriertem interface habe ich hierher: https://www.java-forum.org/thema/java-nach-bestimmter-dateiendung-suchen.109257/
        File[] files = StoreCustomers.parent.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".ser");
            }
        });

        for (File f : files) {
            try (FileInputStream fileInputStream = new FileInputStream(f);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Customer customer = (Customer) objectInputStream.readObject();
                list.add(customer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
