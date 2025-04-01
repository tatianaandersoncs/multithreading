package org.example;

public class MultithreadingExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        Thread t1 = new Thread(new BankTransaction(account), "Thread-1");
        Thread t2 = new Thread(new BankTransaction(account), "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
