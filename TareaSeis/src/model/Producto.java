package model;

public class Producto {

    private String nombrePr;
    private String categoria;
    private double precio;
    private int cantidadDis;

    public Producto(String nombrePr, String categoria, double precio, int cantidadDis) {
        this.nombrePr = nombrePr;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDis = cantidadDis;
    }
    public String getNombrePr() {
        return nombrePr;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidadDis() {
        return cantidadDis;
    } 
}