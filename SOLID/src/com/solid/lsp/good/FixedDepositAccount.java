package com.solid.lsp.good;

/**
 * Un Plazo Fijo es una cuenta (Account), pero NO es una cuenta retirable libremente (WithdrawableAccount).
 * Al no heredar un método withdraw() que no puede honrar, se preserva el principio de Liskov.
 */
public class FixedDepositAccount implements Account {
    private final String accountNumber;
    private double balance;

    public FixedDepositAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("[Plazo Fijo %s] Depósito de $%.2f. Saldo actual: $%.2f%n", accountNumber, amount, balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
