package controller;

import javafx.scene.control.*;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.*;
import model.*;

public class ConsultarController {

    @FXML 
    private TableView<Producto> productos;

    @FXML 
    private TableColumn<Producto,String> nombreProd;

    @FXML 
    private TableColumn<Producto,String> categoriaProd;

    @FXML 
    private TableColumn<Producto,Double> precioProd;

    @FXML 
    private TableColumn<Producto,Integer>  cantidadProd;

    @FXML 
    private Label mensaje;

    @FXML 
    private Button btnCerrar;

    @FXML 
    private void initialize(){
        nombreProd.setCellValueFactory(c-> new ReadOnlyStringWrapper(c.getValue().getNombrePr()));
        categoriaProd.setCellValueFactory(c-> new ReadOnlyStringWrapper(c.getValue().getCategoria()));
        precioProd.setCellValueFactory(c-> new ReadOnlyDoubleWrapper(c.getValue().getPrecio()).asObject());
        cantidadProd.setCellValueFactory(c-> new ReadOnlyIntegerWrapper(c.getValue().getCantidadDis()).asObject());
        productos.setItems(Datos.productos());
        btnCerrar.setText("Cerrar");
        mensaje.setText("Cantidad de productos agregados: " + Datos.productos().size());

    }
    @FXML
    private void close(){
        productos.getScene().getWindow().hide();
    }
}
