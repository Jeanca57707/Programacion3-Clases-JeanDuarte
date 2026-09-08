public abstract class Vehiculo{

    private int codigo;
    private String marca;
    private String modelo;
    private int anio;
    private int velocidad;

    public Vehiculo(int codigo, String marca, String modelo, int anio, int velocidad) {
        
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidad = velocidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public abstract void conducir();


    @Override 
    public String toString(){
        return "Codigo: " + codigo + " - " + "Marca: " + marca + " - " + "Modelo: " + modelo + " - " +  "Anio: " + anio + " - " + "Velocidad: " + velocidad +"km/h";
    }


    

}