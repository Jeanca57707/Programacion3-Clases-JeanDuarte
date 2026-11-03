package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Archivos;
import model.Datos;
import javafx.fxml.FXML;

public class ConsultarController {

    @FXML
    private ListView<String> ventas;

    @FXML
    private Button btnCerrar;

    @FXML
    private Label lblTotalGenerado;

    @FXML
    private void initialize() {
        Archivos.leerArchivoVentas();
        ventas.setItems(Datos.ventas());
        lblTotalGenerado.setText(
                "Total de dinero generado: " + String.format("RD$%.2f", totalGenerado()));
    }

    @FXML
    private void close() {
        btnCerrar.getScene().getWindow().hide();
    }

    private double totalGenerado() {
        double total = 0;
        try {
            for (String ventas : Datos.ventas()) {

                StringBuilder partes = new StringBuilder(ventas);
                int inicio = partes.indexOf("RD$");
                String importe = partes.substring(inicio + 3);
                double ganancia = Double.parseDouble(importe);
                total += ganancia;
            }
        } catch (NumberFormatException e) {
            lblTotalGenerado.setText("Error al imprimir el total generado");
        }
        return total;
    }
}
