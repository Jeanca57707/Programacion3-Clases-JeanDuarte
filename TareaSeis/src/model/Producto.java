package model;

public class Producto {

    private String nombrePr;
    private Categoria categoria;
    private double precio;
    private int cantidadDis;

    public Producto(String nombrePr, Categoria categoria, double precio, int cantidadDis) {
        this.nombrePr = nombrePr;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDis = cantidadDis;
    }
    public String getNombrePr() {
        return nombrePr;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidadDis() {
        return cantidadDis;
    } 

}