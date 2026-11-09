package org.example;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== METRO DE QUITO TARIFAS =====");
        TarjetaMetro.mostrarTarifas();
        System.out.println();

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Edad; ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Tiene discapacidad?: ");
        String disc = sc.nextLine();
        boolean discapacidad = disc.equalsIgnoreCase("s");
        System.out.println("Saldo incial: $");
        double saldoInicial = sc.nextDouble();
        sc.nextLine();
        TarjetaMetro t1 = new TarjetaMetro(nombre, cedula,edad,saldoInicial,discapacidad);

        while (true){
            System.out.println("==== METRO DE QUITO ====");
            System.out.println("1. Recargar");
            System.out.println("2. Pagar Viaje");
            System.out.println("3. Consultar Tarjeta");
            System.out.println("4. Simular Tarjeta");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1){
                System.out.print("INgrese un monto a recargar: $");
                double monto = sc.nextDouble();
                sc.nextLine();
                t1.recargar(monto);
            } else if (opcion == 2) {
                t1.pagarViaje();
            } else if (opcion == 3){
                System.out.println("==== DATOS DE LA TARJETA =====");
                t1.mostrarInformacion();
            } else if (opcion == 4) {
                System.out.println("==== SIMULAR VIAJE ====");
                System.out.println("INgrese el monto a simular: ");
                double monto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Si recarga $"+monto+" usted tendria "+t1.calcularViajesDisponibles()+" viajes.");
            } else if (opcion == 5) {
                System.out.println("Saliendo del sistema....");
                break;
            } else {
                System.out.println("Error: Ingrese una opcion valida");
            }
        }
    }


}