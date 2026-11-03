package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import model.*;

public class RegistroController {

    @FXML
    private TextField txtCodigo, txtNombre, txtPrecio, txtCantidad;

    @FXML
    private Label lblMensaje;

    @FXML
    private Button btnRegistar, btnCerrar;

    @FXML
    private void initialize() {
        Archivos.leerArchivoProductos();
        txtCodigo.setPromptText("Codigo del producto");
        txtNombre.setPromptText("Nombre del producto");
        txtPrecio.setPromptText("Precio del producto");
        txtCantidad.setPromptText("Cantidad");
        lblMensaje.setText("");
    }

    @FXML
    private void registar() {
        try {
            if (txtCodigo.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()
                    || txtCantidad.getText().trim().isEmpty()) {
                lblMensaje.setText("No puede dejar campos vacios");
                return;
            }
            String nombre = txtNombre.getText().trim();
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            if(precio <= 0){
                lblMensaje.setText("Ingrese un precio valido");
                return;
            }
            if(cantidad <= 0){
                lblMensaje.setText("Ingrese una cantidad valida");
                return;
            }
            for(Producto pr : Datos.productos()){
                if(pr.getCodigo() == codigo){
                    lblMensaje.setText("Ya existe un producto con este codigo");
                    return;
                }
            }
            Producto p = new Producto(codigo, nombre, precio, cantidad);
            Archivos.guardarProductos(p);

            lblMensaje.setText("Producto Registrado correctamente");
            txtNombre.setText("");
            txtCodigo.setText("");
            txtCantidad.setText("");
            txtPrecio.setText("");

        } catch (NumberFormatException e) {
            lblMensaje.setText("Ingrese números válidos");
        }
    }

    @FXML 
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }

}
