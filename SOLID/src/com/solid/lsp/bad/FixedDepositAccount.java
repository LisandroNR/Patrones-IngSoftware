package com.solid.lsp.bad;

/**
 * Subclase que rompe el contrato de BankAccount.
 * Al violar LSP, no puede ser sustituida en lugar de BankAccount sin provocar errores.
 */
public class FixedDepositAccount extends BankAccount {

    public FixedDepositAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        // VIOLACIÓN LSP: Rompe el comportamiento esperado por clientes que usan BankAccount.
        throw new UnsupportedOperationException("No se pueden retirar fondos de un plazo fijo antes del vencimiento.");
    }
}
