package com.solid.lsp.good;

/**
 * APLICACIÓN DE LSP:
 * Interfaz base para cualquier cuenta: todas admiten depósitos y consulta de saldo.
 */
public interface Account {
    void deposit(double amount);
    double getBalance();
    String getAccountNumber();
}
