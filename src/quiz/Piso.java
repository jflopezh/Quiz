package quiz;

public class Piso {
    private final int NroPiso;
    private Habitacion[] Habitaciones;

    public Piso(int NroPiso) {
        this.NroPiso = NroPiso;
    }

    public int getNroPiso() {
        return NroPiso;
    }

    public Habitacion[] getHabitaciones() {
        return Habitaciones;
    }
    
    public Habitacion getHabitacion(int Numero){
        for(Habitacion h: this.Habitaciones){
            if(h.getNumero() == Numero)
                return h;
        }
        return null;
    }
    
    public void inicializarHabitaciones(int cant){
        if(cant <= 5){
            this.Habitaciones = new Habitacion[cant];
            for (int i = 0; i < cant; i++) {
                this.Habitaciones[i] = new Habitacion(Integer.parseInt(NroPiso+"0"+(i+1)));
            }
        }
    }
    
    public String Info(){
        String x = "Piso " + this.NroPiso;
        x += "\n--------------------------------------------------------------\n";
        for (int i = 0; i < this.Habitaciones.length; i++) {
            if (i != 0) {
                x += "\n..............................................................\n";
            }
            x += this.Habitaciones[i].Info();
        }
        return x;
    }
}
