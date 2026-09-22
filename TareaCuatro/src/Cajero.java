public class Cajero extends Thread {

    private CuentaBancaria cuenta;

    public Cajero(CuentaBancaria cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run(){
        String [] nombres = {"Ana", "Luis", "Carlos", "", "Maria"};
        double [] montos = {1500.0, -200.0, 800.0, 500, 3000.0};

        for(int i = 0; i<nombres.length; i++){

            try{
                cuenta.depositar(nombres[i], montos[i]);
                Thread.sleep(5000);

            }catch(DepositoInvalidoException e){

                System.out.println(e.getMessage());
            }
            catch(InterruptedException e){
                System.out.println("Error al ejecutar el hilo. " + e.getMessage());
            }
        }
    }    
    
}
