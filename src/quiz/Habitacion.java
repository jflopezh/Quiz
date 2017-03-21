package quiz;

public class Habitacion {
    private final int Numero;
    private double PrecioAlquiler;
    private int CapacidadMaxima;
    private Renta Renta;

    public Habitacion(int Numero) {
        this.Numero = Numero;
    }

    public void setCapacidadMaxima(int CapacidadMaxima) {
        this.CapacidadMaxima = CapacidadMaxima;
    }

    public void setPrecioAlquiler(double PrecioAlquiler) {
        this.PrecioAlquiler = PrecioAlquiler;
    }

    public int getNumero() {
        return Numero;
    }

    public double getPrecioAlquiler() {
        return PrecioAlquiler;
    }

    public int getCapacidadMaxima() {
        return CapacidadMaxima;
    }

    public Renta getRenta() {
        return Renta;
    }
    
    public void Rentar(String Desde, String Hasta, Persona Responsable, Persona[] Inquilinos){
        
    }
}
