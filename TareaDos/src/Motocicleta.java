public class Motocicleta extends Vehiculo {

    private int cilindrada;

    public Motocicleta(int codigo, String marca, String modelo, int anio, 
        int velocidad, int cilindrada) {
       
        super(codigo, marca, modelo, anio, velocidad);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override 
    public void conducir(){

        System.out.println("La marca de la Motocicleta es: " +getMarca() + " y conduce a: " + getVelocidad() +"km/h.");
    }

    @Override 
    public String toString(){

        return super.toString() + " - " + "Cilindrada: " + cilindrada;
    }



   
    
}
