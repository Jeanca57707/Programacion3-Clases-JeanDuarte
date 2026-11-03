package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Archivos;

public class InicioController {

    @FXML private Button btnRegistrar, btnInventario, btnVentas, btnConsultar;

    @FXML private void initialize(){
        Archivos.leerArchivoProductos();
    }

    @FXML 
    private void registrar(){
        Ventanas.abrir("registro", "Registro de Productos", btnRegistrar.getScene().getWindow());
    }

    @FXML 
    private void inventario(){
        Ventanas.abrir("inventario", "Inventario", btnInventario.getScene().getWindow());
    }

    @FXML
    private void ventas(){
        Ventanas.abrir("ventas", "Registro de Ventas", btnVentas.getScene().getWindow());
    }

    @FXML 
    private void consultar(){
        Ventanas.abrir("consultar", "Consultar Ventas", btnConsultar.getScene().getWindow());
    }
}
