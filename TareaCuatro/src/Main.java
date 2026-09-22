public class Main{

    public static void main(String[] args){
        
        CuentaBancaria cuenta = new CuentaBancaria(0, null);
        Cajero cajero = new Cajero(cuenta);
            
        Auditor auditor = new Auditor(cuenta);
        try{

            cajero.start();
            auditor.start();

            cajero.join();
            auditor.join();

        }catch(Exception e){

            System.out.println("Erros de ejecucion " + e.getMessage());
        }
        finally{
            System.out.println("=============================");
            System.out.println("Saldo final: " + cuenta.getSaldo());
            System.out.println("==============================");
        }

               
    }
}