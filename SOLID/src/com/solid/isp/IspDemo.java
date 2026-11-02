package com.solid.isp;

import com.solid.isp.good.*;

public class IspDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n>>> [4] ISP - Interface Segregation Principle <<<");

        Printer basicPrinter = new BasicPrinter();
        AllInOneOfficeMachine multiMachine = new AllInOneOfficeMachine();

        // Cliente 1: Solo necesita imprimir
        printDocument(basicPrinter, "Reporte_Ventas.pdf");
        printDocument(multiMachine, "Contrato_Legal.pdf");

        // Cliente 2: Solo necesita escanear
        scanDocument(multiMachine, "DNI_Cliente.pdf");
    }

    private static void printDocument(Printer printer, String doc) {
        printer.print(doc);
    }

    private static void scanDocument(Scanner scanner, String doc) {
        scanner.scan(doc);
    }
}
