package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Datos;
import javafx.fxml.FXML;

public class ConsultarController {

    @FXML private ListView<String> ventas;

    @FXML private Button btnCerrar;

    @FXML private Label lblTotalGenerado;

    @FXML 
    private void initialize(){
        ventas.setItems(Datos.ventas());
        lblTotalGenerado.setText("Total de dinero generado: " + String.format("RD$%.2f", RegistroVentasController.ventasGeneradas));
    }

    @FXML 
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }
    

    
    
}
