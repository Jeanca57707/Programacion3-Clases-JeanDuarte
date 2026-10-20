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
    private Label lblCantidad;

    @FXML
    private TextField precioTxt;

    @FXML
    private TextField cantidadTxt;

    @FXML
    private TextField nombreTxt;

    @FXML
    private Label mensaje;

    @FXML
    private void initialize() {
        nombreTxt.setPromptText("Nombre");
        precioTxt.setPromptText("Precio");
        cantidadTxt.setPromptText("Cantidad");
        lblCantidad.setText("Cantidad de productos agregados: " + Datos.productos().size());
        categorias.setItems(Datos.categorias());
        if (!categorias.getItems().isEmpty()) {
            categorias.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void administar() {
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
            mensaje.setText("No puedes dejar campos vacíos");
            return;
        }

        try {
            Double precio = Double.parseDouble(precioTxt.getText().trim());
            int cantidad = Integer.parseInt(cantidadTxt.getText().trim());

            if (cantidad <= 0) {
                mensaje.setText("Cantidad inválida");
                return;
            }
            if (precio <= 0) {
                mensaje.setText("Precio invalido");
                return;
            }
            if (categorias.getValue() == null) {
                mensaje.setText("Seleccione una categoría");
                return;
            }
            String categoria = String.valueOf(categorias.getValue());

            Producto producto = new Producto(nombre, categoria, precio, cantidad);
            Datos.productos().add(producto);
            lblCantidad.setText("Cantidad de productos agregados: " + Datos.productos().size());

        } catch (NumberFormatException e) {
            mensaje.setText("Ingrese números válidos.");
        }
    }
}
