package controller;

import javafx.scene.control.*;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.transformation.FilteredList;
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
    private ComboBox<Categoria> categorias;

    @FXML 
    private Button btnFiltrar;

    @FXML 
    private Button btnEliminar;

    @FXML 
    private Button btnCerrar;

    @FXML 
    private Label mensaje;

    @FXML 
    private Label valorTotal;

    @FXML
    private FilteredList<Producto> filtrados;


    @FXML 
    private void initialize(){
        nombreProd.setCellValueFactory(c-> new ReadOnlyStringWrapper(c.getValue().getNombrePr()));
        categoriaProd.setCellValueFactory(c-> new ReadOnlyStringWrapper(c.getValue().getCategoria().toString()));
        precioProd.setCellValueFactory(c-> new ReadOnlyDoubleWrapper(c.getValue().getPrecio()).asObject());
        cantidadProd.setCellValueFactory(c-> new ReadOnlyIntegerWrapper(c.getValue().getCantidadDis()).asObject());
        filtrados = new FilteredList<>(Datos.productos(), c-> true);
        productos.setItems(Datos.productos());
        valorTotal.setText("Valor total: " + String.format("RD$%.2f", calcularTotal()));
        mensaje.setText("");
        categorias.setItems(Datos.categorias());
    }


    private double calcularTotal(){

        double valorTotal = 0;

        for(Producto p : productos.getItems()){

            double precio = p.getPrecio();
            int cantidad = p.getCantidadDis();

            valorTotal += precio * cantidad;
        }
        return valorTotal;
    }

    @FXML
    private void eliminar(){

        Producto eliminar = productos.getSelectionModel().getSelectedItem();
        if(eliminar == null){
            mensaje.setText("Elija un producto primero");
            return;
        }
        Datos.productos().remove(eliminar);
        mensaje.setText("Producto eliminado correctamente");
        valorTotal.setText("Valor total: " + String.format("RD$%.2f", calcularTotal()));
    }

    @FXML 
    private void filtrarPorCat(){
        Categoria categoria = categorias.getSelectionModel().getSelectedItem();
        if(categoria == null){
            filtrados.setPredicate(c-> true);
            mensaje.setText("Categoria inválida");
            return;
        }
        filtrados.setPredicate(c-> categoria.equals(c.getCategoria()));
    }

    @FXML
    private void close(){
        productos.getScene().getWindow().hide();
    }
}
