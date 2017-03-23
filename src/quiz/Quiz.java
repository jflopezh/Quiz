/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Quiz {

    private static Hotel h;
    private static final Scanner sc = new Scanner(System.in);
    private static Robot r;

    public static void main(String[] args) {
        //Inicializando valores del hotel...
        try {
            r = new Robot();
        } catch (AWTException ex) {
        }
        InicializarHotel();

        //Iniciando menu...
        IniciarMenu();
    }

    private static void InicializarHotel() {
        System.out.print("Ingrese el nombre del Hotel: ");
        h = new Hotel(sc.nextLine());
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese el numero de habitaciones del Piso " + (i + 1) + " (Max 5): ");
            h.getPisos()[i].inicializarHabitaciones(sc.nextInt());
            for (Habitacion h1 : h.getPisos()[i].getHabitaciones()) {
                System.out.println("..............................................................");
                System.out.print("Ingrese el precio de alquiler de la habitacion " + h1.getNumero() + ": ");
                h1.setPrecioAlquiler(sc.nextDouble());
                System.out.print("Ingrese la capacidad maxima de la habiatacion " + h1.getNumero() + ": ");
                h1.setCapacidadMaxima(sc.nextInt());
            }
            System.out.println("--------------------------------------------------------------");
        }

        System.out.println("Hotel inicializado, redireccionando al menu principal...");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
        }
        LimpiarPantalla();
    }

    private static void IniciarMenu() {
        System.out.println("Ingrese la opción correspondiente a la operacion que desea realizar:\n");
        System.out.println("1- Obtener informacion general del hotel");
        System.out.println("2- Obtener informacion general de un piso");
        System.out.println("3- Obtener informacion general de una habitacion");
        System.out.println("4- Inhabilitar una habitacion");
        System.out.println("5- Alquilar una habitacion");
        System.out.println("6- Obtener los ingresos totales por concepto de alquiler de todas las habitaciones");
        System.out.println("7- Obtener los ingresos totales por concepto de alquiler de una habitacion");
        System.out.println("8- Salir del programa\n");
        int Dec = sc.nextInt();
        LimpiarPantalla();
        int ha;
        try {
            switch (Dec) {
                case 1:
                    h.ImprimirInfoHotel();
                    break;
                case 2:
                    System.out.print("Ingrese el numero de piso del cual desea la informacion: ");
                    int p = sc.nextInt() - 1;
                    System.out.println("--------------------------------------------------------------");
                    System.out.println(h.getPisos()[p].Info());
                    break;
                case 3:
                    System.out.print("Ingrese el numero de la habitacion de la cual desea la informacion: ");
                    ha = sc.nextInt();
                    System.out.println("--------------------------------------------------------------");
                    System.out.println(h.getHabitacion(ha).Info());
                    break;
                case 4:
                    System.out.print("Ingrese el número de la habitacion que desea inhabilitar: ");
                    ha = sc.nextInt();
                    if (h.getHabitacion(ha).estaOcupada()) {
                        h.getHabitacion(ha).Inhabilitar();
                        System.out.println("\nLa habitacion " + ha + " ha sido inhabilitada");
                    } else {
                        System.out.println("La habitacion ya se encuentra inhabilitada");
                    }
                    break;
                case 5:
                    Alquilar();
                    break;
                case 6:
                    h.IngresosTotales();
                    break;
                case 7:
                    System.out.print("Ingrese la habitacion de la cual quiere saber los ingresos: ");
                    h.IngresosHabitacion(sc.nextInt());
                    break;
                case 8:
                    System.out.println("Hasta Pronto!");
                    break;
                default:
                    System.out.println("El valor ingresado no es valido");
                    break;
            }
        } catch (Exception e) {
            System.out.println("El valor ingresado no es valido" + e);
        }
        System.out.println("--------------------------------------------------------------");
        if (Dec != 8) {
            IniciarMenu();
        }
    }

    private static void Alquilar() {
        System.out.print("Ingrese la habitacion que desea alquilar: ");
        int ha = sc.nextInt();
        System.out.print("Ingrese la fecha de inicio del alquiler (dd-mm-aaaa): ");
        String ini = sc.next();
        System.out.print("Ingrese la cantidad de dias que se alquilara al habitacion: ");
        int dias = sc.nextInt();
        System.out.print("Ingrese la cantidad de personas a las que se alquilara la "
                + "habitacion (Incluyendo el responsable): ");
        int cant = sc.nextInt();
        while (cant > h.getHabitacion(ha).getCapacidadMaxima()) {
            System.out.println("El valor ingresado supera la capacidad maxima de la habitacion."
                    + " Por favor ingrese de nuevo: ");
            cant = sc.nextInt();
        }
        Persona Responsable = null;
        Persona[] Inquilinos = new Persona[cant];
        for (int i = 0; i < cant; i++) {
            Inquilinos[i] = new Persona();
            if (i == 0) {
                System.out.println("\nIngrese los datos del responsable:\n");
            } else {
                System.out.println("\nIngrese los datos del acompañante " + i + ":\n");
            }
            System.out.print("Nombre: ");
            Inquilinos[i].setNombre(sc.next());
            System.out.print("Apellido: ");
            Inquilinos[i].setApellido(sc.next());
            System.out.print("Cedula: ");
            Inquilinos[i].setCedula(sc.next());
            System.out.print("Telefono: ");
            Inquilinos[i].setTelefono(sc.next());
            if (i == 0) {
                Responsable = Inquilinos[i];
            }
        }
        Renta ren = new Renta(h.getCantRentas(), h.getHabitacion(ha), ini, dias, Responsable, Inquilinos);
        h.addRenta(ren);
        h.getHabitacion(ha).Rentar(ren);
        System.out.println("--------------------------------------------------------------");
        System.out.println("La habitacion " + ha + " ha sido rentada");
    }

    private static void LimpiarPantalla() {
        try {
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_L);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_L);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        System.out.println("Hotel " + h.getNombre());
        System.out.println("--------------------------------------------------------------");
    }
}
