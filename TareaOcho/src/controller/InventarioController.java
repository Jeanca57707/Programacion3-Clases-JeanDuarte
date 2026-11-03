package controller;

import model.*;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InventarioController {

    @FXML private TableView<Producto> tablaProductos;

    @FXML private TableColumn<Producto,String> nombreProd;

    @FXML private TableColumn<Producto,Integer> codigoProd, cantidadProd;

    @FXML private TableColumn<Producto,Double> precioProd;

    @FXML private Button btnCerrar;

    @FXML 
    private void initialize(){

        Archivos.leerArchivoProductos();
        codigoProd.setCellValueFactory(c -> (new ReadOnlyIntegerWrapper(c.getValue().getCodigo()).asObject()));
        cantidadProd.setCellValueFactory(c -> (new ReadOnlyIntegerWrapper(c.getValue().getCantidadDis()).asObject()));
        nombreProd.setCellValueFactory(c -> (new ReadOnlyStringWrapper(c.getValue().getNombre())));
        precioProd.setCellValueFactory(c -> (new ReadOnlyDoubleWrapper(c.getValue().getPrecio())).asObject());
        tablaProductos.setItems(Datos.productos());
    }

    @FXML 
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }
    
}
