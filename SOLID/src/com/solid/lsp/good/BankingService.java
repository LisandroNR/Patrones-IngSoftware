package com.solid.lsp.good;

import java.util.List;

public class BankingService {
    /**
     * Este método solo acepta cuentas que garantizan contractualmente retiros.
     * Cualquier subtipo de WithdrawableAccount sustituye a la interfaz sin fallar.
     */
    public void processWithdrawals(List<WithdrawableAccount> accounts, double amount) {
        for (WithdrawableAccount account : accounts) {
            account.withdraw(amount);
        }
    }

    /**
     * Este método acepta cualquier cuenta para depósitos.
     */
    public void processDeposits(List<Account> accounts, double amount) {
        for (Account account : accounts) {
            account.deposit(amount);
        }
    }
}
