package com.solid.lsp.bad;

/**
 * VIOLACIÓN DEL PRINCIPIO DE SUSTITUCIÓN DE LISKOV (LSP)
 *
 * La clase base asume que TODA cuenta bancaria permite realizar retiros.
 */
public class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.balance -= amount;
        System.out.println("Retiro exitoso de $" + amount + ". Saldo restante: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
