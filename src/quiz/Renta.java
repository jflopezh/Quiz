package quiz;

public class Renta {
    private final int CantDias;
    private final Persona Responsable;
    private final Persona[] Inquilinos;
    private final Habitacion Habitacion;

    public Renta(int CantDias, Persona Responsable, Persona[] Inquilinos, Habitacion Habitacion) {
        this.CantDias = CantDias;
        this.Responsable = Responsable;
        this.Inquilinos = Inquilinos;
        this.Habitacion = Habitacion;
    }

    public int getCantDias() {
        return CantDias;
    }

    public Persona getResponsable() {
        return Responsable;
    }

    public Persona[] getInquilinos() {
        return Inquilinos;
    }

    public Habitacion getHabitacion() {
        return Habitacion;
    }
}
