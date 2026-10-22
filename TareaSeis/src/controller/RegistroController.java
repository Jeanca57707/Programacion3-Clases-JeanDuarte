package controller;

import javafx.scene.control.*;
import javafx.fxml.*;
import model.*;

public class RegistroController {

    @FXML
    private ComboBox<Categoria> categorias;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnAdministrar;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField precioTxt;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Label lblMensaje;

    @FXML
    private void initialize() {
        nombreTxt.setPromptText("Nombre");
        precioTxt.setPromptText("Precio");
        cantidadTxt.setPromptText("Cantidad");
        categorias.setItems(Datos.categorias());
        if (!categorias.getItems().isEmpty()) {
            categorias.getSelectionModel().selectFirst();
        }
        lblMensaje.setText("");
    }

    @FXML
    private void administrar() {
        Ventanas.abrir("Administrar", "Administrar categorias", btnAdministrar.getScene().getWindow());
    }

    @FXML
    private void consultar() {
        Ventanas.abrir("Consultar", "Consultar", btnConsultar.getScene().getWindow());
    }

    @FXML
    private void guardar() {

        String nombre = nombreTxt.getText().trim();

        if (nombre.isEmpty() || precioTxt.getText().trim().isEmpty() || cantidadTxt.getText().trim().isEmpty()) {
            lblMensaje.setText("No puedes dejar campos vacíos");
            return;
        }

        try {
            Double precio = Double.parseDouble(precioTxt.getText().trim());
            int cantidad = Integer.parseInt(cantidadTxt.getText().trim());

            if (cantidad <= 0) {
                lblMensaje.setText("Cantidad inválida");
                return;
            }
            if (precio <= 0) {
                lblMensaje.setText("Precio invalido");
                return;
            }
            if (categorias.getValue() == null) {
                lblMensaje.setText("Seleccione una categoría");
                return;
            }
            Categoria categoria = categorias.getSelectionModel().getSelectedItem();

            Producto producto = new Producto(nombre, categoria, precio, cantidad);
            Datos.productos().add(producto);
            lblMensaje.setText("Cantidad de productos agregados: " + Datos.productos().size());

            nombreTxt.clear();
            precioTxt.clear();
            cantidadTxt.clear();
            categorias.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            lblMensaje.setText("Ingrese números válidos.");
        } 
    }
}
