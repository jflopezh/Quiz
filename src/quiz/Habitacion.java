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

    public void Rentar(Renta r) {
        this.Renta = r;
    }

    public void Inhabilitar() {
        this.Renta = null;
    }
    
    public boolean estaOcupada() {
        return (Renta != null);
    }

    public String Info() {
        String x = "Habitacion " + this.Numero + "\nPrecio de Alquiler: $" + this.PrecioAlquiler
                + "\nCapacidad Maxima: " + this.CapacidadMaxima;
        if (this.Renta != null) {
            x += "\n\nResponsable:\n\n" + this.Renta.getResponsable().toString() + "\n\nAcompañantes: ";
            for (int i = 1; i < this.Renta.getInquilinos().length; i++) {
                x += "\n\n" + i + "- " + this.Renta.getInquilinos()[i].toString();
            }
        } else {
            x += "\n\nInquilinos: La habitacion se encuentra desocupada";
        }
        return x;
    }
}
