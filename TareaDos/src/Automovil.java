public class Automovil extends Vehiculo{

    private int cantidadPuertas;

    public Automovil(int codigo, String marca, String modelo, int anio,  
        int velocidad, int cantidadPuertas) {
        
        super(codigo, marca, modelo, anio, velocidad);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        
        if(cantidadPuertas > 0){
          this.cantidadPuertas = cantidadPuertas;
        }
    }

    @Override
    public void conducir(){

        System.out.println("La marca del Automovil es: " +getMarca() + " y conduce a: " + getVelocidad() +"km/h.");
    }

    @Override 
    public String toString(){

        return super.toString() + " - " + "Cantidad de puertas: " + cantidadPuertas;
    }
   
}
