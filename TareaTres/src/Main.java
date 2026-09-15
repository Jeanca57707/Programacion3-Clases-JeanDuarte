public class Main{


    public static void main(String[] args){

        String [] nombres = {"Juan Perez", "Ana Lopez", "Carlos Ruiz", "Maria DIaz", "Luis Marte"};
        String [] correos = {"juan@ucne.edu","ana@gmail.com","carlos@ucne.edu","maria@ahoo.com","luis@ucne.edu"};

        double [] parcial1 = {8.5,9.0,6.3,4.5,7.8};
        double [] parcial2 = {7.0,8.5,5.9,6.0,9.2};
        double [] parcial3 = {9.0,7.5,4.8,8.0,6.5};

        double [] promedio = calcularPromedio(parcial1, parcial2, parcial3);
        String [] estados = estados(promedio);

        System.out.println("\nNOMBRE\t\tPROMEDIO\tESTADO\n");
        for(int i = 0; i < nombres.length; i++){

            System.out.printf("%s\t%.2f\t\t%s%n",nombres[i] ,promedio[i] ,estados[i]);

        }

        System.out.println("\nEstadisticas del grupo:\n");
        System.out.printf("Promedio general: " +"%.2f%n", promedioGeneral(promedio));
        System.out.println("Estudainte con el promedio mas alto: " + promedioGrande(promedio, nombres));
        System.out.println("Estudiante con el menor promedio: "+ promedioMenor(promedio, nombres));
        cantidadAprobados_Reprob(promedio);

        System.out.println("\nFiltro por correo:\n");

        filtrarPorCorreo(correos, nombres);
        
        String buscar = "lopez";
        System.out.println("\nBuscamos a: " + buscar + "\n");
        int indice = buscarEstudiantePorNombre(nombres, buscar);
        System.out.printf("%s\t%s\t%.2f", nombres[indice], correos[indice], promedio[indice]);

        
    }

    public static double[] calcularPromedio(double[]a, double[]b, double[]c){

        double [] listaPromedio = new double[5];
        for(int i = 0; i < a.length; i ++){

            double sumParciales = 0;
            double promedio = 0;

            sumParciales += a[i] + b[i] + c[i];
            promedio = sumParciales/3;

            listaPromedio[i] = promedio;
        }

        return listaPromedio;
    }

    public static String [] estados(double [] promedios){

        String [] estados = new String[5];
        for(int i = 0; i < promedios.length; i++){

            if(promedios[i] >= 6.0){
                estados[i] = "Aprobado";
            }
            else{
                estados[i] = "Reprobado";
            }
        }
        return estados;
    }

    public static double promedioGeneral(double[]p){

        double promedioTotal = 0;
        for(double promedio: p){

            promedioTotal += promedio;
        }
        return promedioTotal / p.length;
    }
    public static String promedioGrande(double[]p, String[]n){

        double mejor = p[0];
        int num = 0;
        for (int i = 0; i < p.length;i++){
            if(p[i] > mejor){
                mejor = p[i];
                num = i;
            }
        }
        return n[num];
    }
    public static String promedioMenor(double[]p, String[]n){

        double menor = p[0];
        int num = 0;
        for (int i = 0; i < p.length;i++){
            if(p[i] < menor){
                menor = p[i];
                num = i;
            }
        }
        return n[num];
    }

    public static void cantidadAprobados_Reprob(double[] promedio){

       int aprobados = 0;
       int reprobados = 0;

       for (double p: promedio){

        if(p >= 6.0){
            aprobados++;
        }
        else{
            reprobados++;
        }
       }

       System.out.println("\nCantidad de Aprobados: " + aprobados);
       System.out.println("\nCantidad de Reprobados: " + reprobados);
    }

    //Funcion que filtra los estudiantes por el correo que termine en "@ucne.edu"
    public static void filtrarPorCorreo(String[]correos, String[]nombres){

        for (int i = 0; i < correos.length; i++){

            if(correos[i].contains("@ucne.edu")){

                System.out.println(nombres[i].toUpperCase() + " - " + correos[i]);
            }
        }
    }


    //Funcion que busca el estudiante por el nombre
    public static int buscarEstudiantePorNombre(String[]nombres, String nombre){

        for(int i = 0; i < nombres.length; i++){

            if(nombres[i].toLowerCase().contains(nombre.toLowerCase())){


                return i;
            }
        }
        return -1;
    }

}