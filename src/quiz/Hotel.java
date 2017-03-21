package quiz;

import java.util.ArrayList;

public class Hotel {
    private final String Nombre;
    private final Piso[] Pisos;
    private final ArrayList<Renta> Rentas;
    
    public Hotel(String Nombre){
        this.Nombre = Nombre;
        this.Pisos = new Piso[3];
        this.Pisos[0] = new Piso(1);
        this.Pisos[1] = new Piso(2);
        this.Pisos[2] = new Piso(3);
        this.Rentas = new ArrayList<>(); 
    }

    public Piso[] getPisos() {
        return Pisos;
    }

    public ArrayList<Renta> getRentas() {
        return Rentas;
    }
    
    
}
