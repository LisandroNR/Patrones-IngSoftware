package com.solid.lsp;

import com.solid.lsp.good.*;
import java.util.List;

public class LspDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n>>> [3] LSP - Liskov Substitution Principle <<<");

        SavingsAccount cajaAhorro = new SavingsAccount("CA-001", 1000.0);
        FixedDepositAccount plazoFijo = new FixedDepositAccount("PF-999", 5000.0);

        BankingService bankingService = new BankingService();

        // 1. Todas las cuentas pueden recibir depósitos de manera segura (cumplen Account)
        List<Account> todasLasCuentas = List.of(cajaAhorro, plazoFijo);
        bankingService.processDeposits(todasLasCuentas, 200.0);

        // 2. Solo las cuentas retirables se pasan a operaciones de retiro
        // El compilador y el diseño garantizan que no ocurrirán excepciones inesperadas en tiempo de ejecución.
        List<WithdrawableAccount> cuentasRetirables = List.of(cajaAhorro);
        bankingService.processWithdrawals(cuentasRetirables, 150.0);
    }
}
