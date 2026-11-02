package com.solid;

import com.solid.srp.SrpDemo;
import com.solid.ocp.OcpDemo;
import com.solid.lsp.LspDemo;
import com.solid.isp.IspDemo;
import com.solid.dip.DipDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      DEMOSTRACIÓN DE PRINCIPIOS S.O.L.I.D.      ");
        System.out.println("=================================================");

        // 1. Single Responsibility Principle
        SrpDemo.run();

        // 2. Open/Closed Principle
        OcpDemo.run();

        // 3. Liskov Substitution Principle
        LspDemo.run();

        // 4. Interface Segregation Principle
        IspDemo.run();

        // 5. Dependency Inversion Principle
        DipDemo.run();

        System.out.println("\n=================================================");
        System.out.println("        TODAS LAS DEMOS COMPLETADAS CON ÉXITO     ");
        System.out.println("=================================================");
    }
}
