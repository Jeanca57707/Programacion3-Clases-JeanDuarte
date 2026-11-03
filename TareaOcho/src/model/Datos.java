package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Datos {

    public static final ObservableList<Producto> PRODUCTOS = FXCollections.observableArrayList();
    public static final ObservableList<String> NOMBRE_PRODUCTO = FXCollections.observableArrayList();
    public static final ObservableList<String> VENTAS = FXCollections.observableArrayList(); 

    public static ObservableList<Producto> productos(){
        return PRODUCTOS;
    }

    public static ObservableList<String> nombresProductos(){
        return NOMBRE_PRODUCTO;
    }
    public static ObservableList<String> ventas(){
        return VENTAS;
    }
    
}
