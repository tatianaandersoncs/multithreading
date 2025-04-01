package org.example;

class BankTransaction implements Runnable {
    private final BankAccount account;

    public BankTransaction(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            account.withdraw(50);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}