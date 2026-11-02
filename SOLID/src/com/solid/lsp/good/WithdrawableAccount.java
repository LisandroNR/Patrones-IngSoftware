package com.solid.lsp.good;

/**
 * APLICACIÓN DE LSP:
 * Subtipo específico para aquellas cuentas que sí permiten retiros arbitrarios.
 * Cualquier implementación de esta interfaz podrá sustituir a otra sin romper nada.
 */
public interface WithdrawableAccount extends Account {
    void withdraw(double amount);
}
