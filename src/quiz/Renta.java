package quiz;

public class Renta {
    private final int ID;
    private final Habitacion Habitacion;
    private final String FechaInicio;
    private final int CantDias;
    private final Persona Responsable;
    private final Persona[] Inquilinos;

    public Renta(int ID, Habitacion Habitacion, String FechaInicio, int CantDias, Persona Responsable, Persona[] Inquilinos) {
        this.ID = ID;
        this.Habitacion = Habitacion;
        this.FechaInicio = FechaInicio;
        this.CantDias = CantDias;
        this.Responsable = Responsable;
        this.Inquilinos = Inquilinos;
    }

    public int getID() {
        return ID;
    }
    
    public Habitacion getHabitacion() {
        return Habitacion;
    }

    public String getFechaInicio() {
        return FechaInicio;
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
    
    public double getTotal() {
        return (CantDias * Habitacion.getPrecioAlquiler());
    }

    @Override
    public String toString() {
        return "Renta " + ID + "\nHabitacion: " + Habitacion.getNumero() + "\nFecha de Inicio: " 
              + FechaInicio + "\nCantidad de Dias: " + CantDias + "\nResponsable: " + Responsable.getNombre()
              + "\nValor total: $" + this.getTotal();
    }    
}
