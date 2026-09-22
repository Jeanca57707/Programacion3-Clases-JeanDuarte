public class CuentaBancaria {
  
    private double saldo; 
    private String nombre;

    public CuentaBancaria(double saldo, String nombre) {
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
    public synchronized void depositar(String nombre,double monto)throws DepositoInvalidoException{

        if(monto <= 0){
            throw new DepositoInvalidoException("Monto invalido. " + monto);
        }
        if(nombre.isEmpty()){
            throw new DepositoInvalidoException("Error. Cliente sin nombre." );
        }

        saldo += monto;
        System.out.println("[Deposito]  OK | " + nombre + " | " + monto);
    }   
}
