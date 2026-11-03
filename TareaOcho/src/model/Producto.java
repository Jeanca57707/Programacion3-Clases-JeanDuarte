package model;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidadDis;

    public Producto(int codigo, String nombre, double precio, int cantidadDis) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDis = cantidadDis;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDis() {
        return cantidadDis;
    }

    public void setCantidadDis(int cantidadDis) {
        this.cantidadDis = cantidadDis;
    }

    @Override
    public String toString() {
        return getCodigo() + "; " + getNombre() + "; " + String.format("%.2f", getPrecio()) + "; " + getCantidadDis();
    }
}
