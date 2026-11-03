package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Archivos;
import model.Datos;
import model.Producto;

public class RegistroVentasController {

    @FXML
    private ComboBox<String> productos;

    @FXML
    private TextField txtCantidad;

    @FXML
    private Label lblMensaje, lblImporteTotal;

    @FXML private Button btnVenta, btnCerrar;

    private static Producto productoElegido;
    public static double ventasGeneradas = 0;

    @FXML
    private void initialize() {
        Archivos.leerArchivoProductos();
        productos.setItems(Datos.nombresProductos());
        txtCantidad.setPromptText("Ingrese la cantidad de productos deseados");
        if(!productos.getItems().isEmpty()){
            productos.getSelectionModel().selectFirst();
        }
        lblMensaje.setText("");
        lblImporteTotal.setText("");
    }

    @FXML
    private void venta() {
        try {
            double importeGenerado = 0;
            String producto = productos.getSelectionModel().getSelectedItem();
            if (producto.isBlank() || txtCantidad.getText().trim().isEmpty()) {
                lblMensaje.setText("Seleccione un producto e ingrese la cantidad deseada");
            }
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            for (Producto p : Datos.productos()) {
                if (p.getNombre().equals(producto)) {
                    productoElegido = p;
                    break;
                }
            }
            if(productoElegido == null){
                lblMensaje.setText("Elija un producto");
                return;
            }
            if (productoElegido.getCantidadDis() < cantidad) {
                lblMensaje.setText("Cantidad insuficiente de productos");
                return;
            }

            productoElegido.setCantidadDis(productoElegido.getCantidadDis() - cantidad);
            importeGenerado = productoElegido.getPrecio() * cantidad;
            ventasGeneradas += importeGenerado;

            String venta = productoElegido.getNombre() + "\tcantidad vendida: " + cantidad +" \timporte generado: " 
            + String.format("RD$%.2f", importeGenerado);

            Archivos.guardarVenta(venta);
            Archivos.actualizarProducto(productoElegido);

            lblMensaje.setText("¡Venta realizada!");
            lblImporteTotal.setText("Importe total: " + String.format("RD$%.2f", importeGenerado));
            txtCantidad.setText("");
            productos.setValue("");
            productoElegido = null;

        } catch (NumberFormatException e) {
            lblMensaje.setText("Error de formato de número: Ingrese un número válido");
        }

    }

    @FXML 
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }

}
