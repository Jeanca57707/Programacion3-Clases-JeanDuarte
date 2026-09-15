public class Main{


    public static void main(String[] args){

        String [] nombres = {"Juan Perez", "Ana Lopez", "Carlos Ruiz", "Maria DIaz", "Luis Marte"};
        String [] correos = {"juan@ucne.edu","ana@gmail.com","carlos@ucne.edu","maria@ahoo.com","luis@ucne.edu"};

        double [] parcial1 = {8.5,9.0,6.3,4.5,7.8};
        double [] parcial2 = {7.0,8.5,5.9,6.0,9.2};
        double [] parcial3 = {9.0,7.5,4.8,8.0,6.5};

        double [] promedio = calcularPromedio(parcial1, parcial2, parcial3);
        String [] estados = estados(promedio);

        System.out.println("NOMBRE\t\tPROMEDIO\tESTADO");
        for(int i = 0; i < nombres.length; i++){

            System.out.printf("%s\t%.2f\t\t%s%n",nombres[i] ,promedio[i] ,estados[i]);

        }

        System.out.println("\nEstadisticas del grupo\n");





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
        for (int i = 0; i < p.length;i++){
            if(p[i] > mejor){
                mejor = p[i];
            }
        }
        return n[1];
    }
    public static String promedioMenor(double[]p, String[]n){

        double menor = p[0];
        for (int i = 0; i < p.length;i++){
            if(p[i] < menor){
                menor = p[i];
            }
        }
        return n[1];
    }

}