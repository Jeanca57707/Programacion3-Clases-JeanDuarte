import java.util.*;

public static void main(String[] args) {

    Automovil automovil = new Automovil(023, "Ford", "Focus", 2014, 80, 4);
    Motocicleta motocicleta = new Motocicleta(33, "Honda", "Honda CBR", 2018, 90, 6);
    Camion camion = new Camion(67, "Ford", "F-50", 2010, 60, 400, 300);
    Camion camion2 = new Camion(80, "RAM", "1500", 2015, 75, 220, 180);
    Motocicleta motocicleta2 = new Motocicleta(69, "Suzuki", "GSX", 2019, 90, 6);
   
   
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    vehiculos.add(automovil);
    vehiculos.add(motocicleta);
    vehiculos.add(camion);
    vehiculos.add(camion2);
    vehiculos.add(motocicleta2);

    for( Vehiculo v : vehiculos){

        System.out.println("\n");
        if( v instanceof Camion){
          System.out.println(v.getMarca() + " Esta implentando Cargable");
        }
        System.out.println(v.toString());
        v.conducir();
        v.getClass();
        System.out.println("\n");
    }

    camion.cargar(130);
    camion.descargar();

    System.out.println("\n");

    camion2.cargar(100);
    camion2.descargar();

    
}
