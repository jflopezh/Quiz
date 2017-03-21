/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Quiz {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Hotel: ");
        Hotel h = new Hotel(sc.next());
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese el numero de habitaciones del Piso " + (i+1) + " (Max 5): ");
            h.getPisos()[i].inicializarHabitaciones(sc.nextInt());
            System.out.println();
            for (int j = 0; j < h.getPisos()[i].getHabitaciones().length; j++) {
                System.out.println("Ingrese el precio de alquiler de la habitacion " + h.getPisos()[i].getHabitaciones()[j] + ": ");
            }
        }
        
    }
    
}
