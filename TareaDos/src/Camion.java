public class Camion extends Vehiculo implements Cargable {

    private int capacidadCraga;

    private int cargaActual;

    public Camion(int codigo, String marca, String modelo, int anio, 
        int velocidad, int capacidadCraga, int cargaActual) {

        super(codigo, marca, modelo, anio, velocidad);
        this.capacidadCraga = capacidadCraga;
        this.cargaActual = cargaActual;
    }

    public int getCapacidadCraga() {
        return capacidadCraga;
    }

    public void setCapacidadCraga(int capacidadCraga) {
        this.capacidadCraga = capacidadCraga;
    }

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        this.cargaActual = cargaActual;
    }

    @Override 
    public void conducir(){

        System.out.println("La marca del Camion es: " + getMarca() + " y conduce a: " + getVelocidad() +"km/h.");
    }

    @Override 
    public void cargar(double peso){

        System.out.println("El camion " + getMarca() + " carga: " + peso);

    }

    @Override 
    public void descargar(){

        System.out.println("\nEl camion " + getMarca() +" acaba de descargar lo que llevaba");
    }

    @Override 
    public  String toString(){

        return super.toString() + " - " + "Capacidad de carga: " + capacidadCraga + " - " + "Carga actual: " + cargaActual;
    }
    
}
