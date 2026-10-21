package controller;

import javafx.scene.control.*;
import javafx.fxml.*;
import model.*;

public class AdministrarController {

    @FXML 
    private ListView<Categoria> categorias;

    @FXML 
    private TextField txtNuevaCat;

    @FXML 
    private Button btnAgregarCat;

    @FXML 
    private Button btnEliminar;

    @FXML 
    private Button btnCerrar;

    @FXML 
    private Label mensaje;

    @FXML 
    private void initialize(){

        categorias.setItems(Datos.categorias());
        txtNuevaCat.setPromptText("Nombre de la nueva categoria");
        mensaje.setText("");
    }
    @FXML 
    private void agregarCat(){

        String nuevaCategoria = txtNuevaCat.getText().trim().toLowerCase();

        if(nuevaCategoria.isEmpty()){
            mensaje.setText("Escriba una categoria primero");
            return;
        }
       
        for(Categoria c : categorias.getItems()){

            String cat = c.toString();
            if(nuevaCategoria.equals(cat)){
                mensaje.setText("Esta categoría ya se encuentra agregada");
                return;
            }
        }
        Categoria newCat = new Categoria(nuevaCategoria);
        Datos.categorias().add(newCat);
        mensaje.setText("Categoria agregada correctamente");
        txtNuevaCat.clear();
    }

    @FXML 
    private void eliminarCat(){
        Categoria eliminar = categorias.getSelectionModel().getSelectedItem();
        if(eliminar == null){
            mensaje.setText("Elija una categoría");
            return;
        }
        Datos.categorias().remove(eliminar);
        mensaje.setText("Categoria eliminada");
    }

    @FXML 
    private void close(){
        categorias.getScene().getWindow().hide();
    }    
}
