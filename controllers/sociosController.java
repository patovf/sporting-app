/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportingapplication.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Paulina Vaira
 */
public class sociosController implements Initializable {
    
    @FXML
    private AnchorPane nuevoSocio_panel;

    @FXML
    private AnchorPane nuevoSocio_form;

    @FXML
    private Button nuevoSocio_crearBtn;

    @FXML
    private Button nuevoSocio_cancelarBtn;

    @FXML
    private TextField nuevoSocio_socioID;

    @FXML
    private TextField nuevoSocio_nombre;

    @FXML
    private TextField nuevoSocio_apellido;

    @FXML
    private TextField nuevoSocio_sede;

    @FXML
    private ComboBox<?> nuevoSocio_cabezaFamilia;

    @FXML
    private ComboBox<?> nuevoSocio_perteneceFamilia;

    @FXML
    private AnchorPane socios_panel;

    @FXML
    private AnchorPane socios_filtros;

    @FXML
    private TextField socios_filtroSocioID;

    @FXML
    private TextField socios_filtroNombre;

    @FXML
    private TextField socios_filtroApellido;

    @FXML
    private TextField socios_filtroSede;

    @FXML
    private AnchorPane socios_tablaVista;

    @FXML
    private TableView<?> socios_tabla;

    @FXML
    private TableColumn<?, ?> socios_tablaSocioID;

    @FXML
    private TableColumn<?, ?> socios_tablaNombre;

    @FXML
    private TableColumn<?, ?> socios_tablaApellido;

    @FXML
    private TableColumn<?, ?> socios_tablaFechaAlta;

    @FXML
    private TableColumn<?, ?> socios_tablaSede;

    @FXML
    private Button socios_agregarBtn;
    
    private String[] yesOrNo = {"Si", "No"};
    
    public void listaCabezaFamilia() {
        List<String> listOptions = new ArrayList<>();
        
        for(String data: yesOrNo) {
            listOptions.add(data);
        }
        
        ObservableList observableList = FXCollections.observableArrayList(listOptions);
        
        nuevoSocio_cabezaFamilia.setItems(observableList);
    }
    
    public void imprimirRecibo() {
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaCabezaFamilia();
    }

    public void switchToSocios(boolean value) {
        socios_panel.setVisible(value);
    }
   
    public void switchToNuevoSocio() {
        nuevoSocio_panel.setVisible(true);
    }

}
