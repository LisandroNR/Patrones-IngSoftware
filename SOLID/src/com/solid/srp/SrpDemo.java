package com.solid.srp;

import com.solid.srp.good.Invoice;
import com.solid.srp.good.InvoicePrinter;
import com.solid.srp.good.InvoiceRepository;

public class SrpDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n>>> [1] SRP - Single Responsibility Principle <<<");

        // Creamos la factura (lógica de negocio / modelo)
        Invoice invoice = new Invoice("INV-2026-001", 1500.0, 0.21);

        // Imprimimos la factura (responsabilidad de presentación)
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        // Guardamos la factura (responsabilidad de persistencia)
        InvoiceRepository repository = new InvoiceRepository();
        repository.save(invoice);
    }
}
