public class Mascota{

    private String nombre;
    private String especie;
    private int edad;
    private double peso;

    public Mascota(String nombre, String especie, int edad, double peso){

        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
    
    }

    public String getNombre(){

        return nombre;
    }
    public String getEspecie(){

        return especie;
    }
    public int getEdad(){

        return edad;
    }
    public double getPeso(){

        return peso;
    }

    public void mostrarDatos(){

        System.out.println("Nombre: " + getNombre() + "\n" + "Especie: " + getEspecie() + "\n" + "Edad: " + 
        getEdad() + " anio/s\n" + "Peso: " + getPeso() +"kg\n");
    }

    public void clasificarPeso(){

        if(getPeso() < 2){

            System.out.println("Bajo Peso");
        }
        else if (getPeso()> 2 && getPeso() < 10){

            System.out.println("Peso Normal");

        }
        else{

            System.out.println("Sobre Peso");
        }
    }
}