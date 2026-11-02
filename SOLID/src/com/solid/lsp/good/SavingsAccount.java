package com.solid.lsp.good;

public class SavingsAccount implements WithdrawableAccount {
    private final String accountNumber;
    private double balance;

    public SavingsAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("[Caja de Ahorro %s] Depósito de $%.2f. Saldo actual: $%.2f%n", accountNumber, amount, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta " + accountNumber);
        }
        balance -= amount;
        System.out.printf("[Caja de Ahorro %s] Retiro de $%.2f completado. Saldo restante: $%.2f%n", accountNumber, amount, balance);
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
