package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
      //  lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient balance.");
            }
        } finally {
          //  lock.unlock();
        }
    }
}