public class Main {
    

    public static void main(String [] args){

        Mascota perro = new Mascota("Tobbie", "Perro", 2, 7.8);
        perro.mostrarDatos();
        perro.clasificarPeso();

        System.out.println("\n=============================");

        Mascota gato = new Mascota("Leon", "Gato", 1, 4.0);
        gato.mostrarDatos();
        gato.clasificarPeso();

        System.out.println("\n=============================");

        Mascota conejo = new Mascota("Rabbit", "Conejo", 3, 10.0);
        conejo.mostrarDatos();
        conejo.clasificarPeso();
    }
}
