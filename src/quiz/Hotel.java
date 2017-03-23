package quiz;

import java.util.ArrayList;

public class Hotel {

    private final String Nombre;
    private final Piso[] Pisos;
    private final ArrayList<Renta> Rentas;
    private int CantRentas;

    public Hotel(String Nombre) {
        this.Nombre = Nombre;
        this.Pisos = new Piso[3];
        this.Pisos[0] = new Piso(1);
        this.Pisos[1] = new Piso(2);
        this.Pisos[2] = new Piso(3);
        this.Rentas = new ArrayList<>();
        this.CantRentas = 1;
    }

    public Piso[] getPisos() {
        return Pisos;
    }

    public void addRenta(Renta r) {
        Rentas.add(r);
        CantRentas++;
    }

    public int getCantRentas() {
        return CantRentas;
    }

    public String getNombre() {
        return Nombre;
    }

    public Habitacion getHabitacion(int Numero) {
        for (Piso p : Pisos) {
            if (p.getHabitacion(Numero) != null) {
                return p.getHabitacion(Numero);
            }
        }
        return null;
    }

    public void ImprimirInfoHotel() {
        System.out.println("Informacion del hotel");
        for (Piso p : Pisos) {
            System.out.println("--------------------------------------------------------------");
            System.out.println(p.Info());
        }
    }

    public void IngresosTotales() {
        double x = 0;
        System.out.println("Rentas de todas las habitaciones del hotel");
        System.out.println("--------------------------------------------------------------");
        for (Renta r : Rentas) {
            System.out.println(r.toString());
            System.out.println("--------------------------------------------------------------");
            x += r.getTotal();
        }
        System.out.println("El total de ingresos obtenidos por concepto de alquiler de todas "
                + "las habitaciones del hotel es de $" + x);
    }

    public void IngresosHabitacion(int Numero) {
        double x = 0;
        System.out.println("Rentas de la habitacion " + Numero);
        System.out.println("--------------------------------------------------------------");
        for (Renta r : Rentas) {
            if (r.getHabitacion().getNumero() == Numero) {
                System.out.println(r.toString());
                System.out.println("--------------------------------------------------------------");
                x += r.getTotal();
            }
        }
        System.out.println("El total de ingresos obtenidos por concepto de alquiler de la "
                + "habitacion " + Numero + " es de $" + x);
    }
}
