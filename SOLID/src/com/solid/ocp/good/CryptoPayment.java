package com.solid.ocp.good;

public class CryptoPayment implements PaymentMethod {
    private final String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("[Cripto Wallet: %s] Transacción de $%.2f enviada a la Blockchain.%n", walletAddress, amount);
    }

    @Override
    public String getName() {
        return "Criptomonedas";
    }
}
