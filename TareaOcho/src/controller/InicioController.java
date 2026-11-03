package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {

    @FXML private Button btnRegistar, btnInventario, btnVentas, btnConsultar;

    @FXML private void initialize(){
        btnRegistar.setText("Registar Producto");
        btnInventario.setText("Ver inventario");
        btnVentas.setText("Realizar Venta");
        btnConsultar.setText("Consultar ventas");
    }

    @FXML 
    private void registrar(){
        Ventanas.abrir("registro", "Registro de Productos", btnRegistar.getScene().getWindow());
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
