package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class Datos {
    private static final ObservableList<Categoria> CATEGORIAS = FXCollections.observableArrayList(); 
    private static final ObservableList<Producto> PRODUCTOS = FXCollections.observableArrayList(); 


    public static ObservableList<Producto> productos(){
        return PRODUCTOS;
    }

    public static ObservableList<Categoria> categorias(){
        return CATEGORIAS;
    }
}
