package com.solid.isp.good;

/**
 * APLICACIÓN DE ISP:
 * Una máquina avanzada puede componer múltiples interfaces específicas
 * según sus capacidades reales.
 */
public class AllInOneOfficeMachine implements Printer, Scanner, Fax {
    @Override
    public void print(String document) {
        System.out.println("[AllInOne] Imprimiendo documento en alta resolución: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("[AllInOne] Escaneando a PDF digital: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("[AllInOne] Enviando fax telefónico con el documento: " + document);
    }
}
