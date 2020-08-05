package de.philipp_ulti.klausur.model.io;

import de.philipp_ulti.klausur.model.logic.Customer;

import java.io.*;

public class StoreCustomers {

    private static File file;
    public static File parent = new File("Customers");

    public static void storeCustomerOnDisk(Customer toStore) {
        if(!parent.exists()) {
            parent.mkdirs();
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream("Customers\\" + toStore.getCustomerId() + ".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(toStore);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * method to store a customer in a new thread
     * @param toStore
     */
    public static void storeCustomerOnDiskConcurrent(Customer toStore) {
        Thread t = new Thread() {
            @Override
            public void run() {
                storeCustomerOnDisk(toStore);
            }
        };
        t.start();
    }

    private static void createFile(File file1) {
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
