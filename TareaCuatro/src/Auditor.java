public class Auditor extends Thread{

    private CuentaBancaria cuenta;

    public Auditor(CuentaBancaria cuenta){
        this.cuenta = cuenta;
    } 

    @Override 
    public void run(){

        for (int i = 0; i <3; i++){

           try{
             System.out.println("[Auditor] Saldo  actual: " + cuenta.getSaldo());
             Thread.sleep(7000);
            
            }catch(InterruptedException e){

             System.out.println("Error de ejecucion del hilo. " + e.getMessage());
           }
        }
    }
}
