package de.philipp_ulti.klausur.model.io;

import java.io.File;

public class RemoveCustomers {

    public static void removeCustomerFromDisk(String customerId) {
        File file = new File("Customers\\" + customerId + ".ser");
        if (!file.exists()) {
            throw new IllegalArgumentException("The file does not exist!");
        } else {
            file.delete();
        }
    }

    /**
     * method to remove a customer in a new thread
     * @param customerId
     */
    public static void removeCustomerFromDiskConcurrent(String customerId) {
        Thread t = new Thread() {
          @Override
          public void run() {
              removeCustomerFromDisk(customerId);
          }
        };
    }

}
