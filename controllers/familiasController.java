/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportingapplication.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sportingapplication.config.database;
import sportingapplication.models.Concepto;
import sportingapplication.models.dto.ConceptoDto;
import sportingapplication.models.AlertMessage;

/**
 *
 * @author Paulina Vaira
 */
public class familiasController implements Initializable {
    
    // --- TABLA DE FAMILIAS ---
    
    @FXML
    private AnchorPane familias_tableView;

    @FXML
    private AnchorPane famiilias_panel;

    @FXML
    private AnchorPane familias_filtros;

    @FXML
    private TextField familias_filtroNombre;

    @FXML
    private AnchorPane familias_tablaVista;

    @FXML
    private TableView<?> familias_tabla;

    @FXML
    private TableColumn<?, ?> familias_tablaNombre;

    @FXML
    private TableColumn<?, ?> familias_tablaCosto;

    @FXML
    private Button familias_agregarBtn;

    @FXML
    private Button familias_editarBtn;
    
    // --- AGREGAR FAMILIA ---
    
    @FXML
    private TextField nuevoConcepto_nombre;

    @FXML
    private TextField nuevoConcepto_descripcion;

    @FXML
    private TextField nuevoConcepto_costo;

    @FXML
    private Button nuevoConcepto_crearBtn;

    @FXML
    private Button nuevoConcepto_cancelarBtn;
    
    // --- EDITAR FAMILIA ---
    
    @FXML
    private AnchorPane editarFamilia_tableView;

    @FXML
    private AnchorPane familias_panel;

    @FXML
    private AnchorPane familias_cabecera;

    @FXML
    private TextField editarFamilia_nombre;

    @FXML
    private ComboBox<?> editarFamilia_socioCabecera;

    @FXML
    private AnchorPane familias_tablaVistaSocios;

    @FXML
    private Button editarFamilia_agregarSocioBtn;

    @FXML
    private Button editarFamilia_eliminarSocioBtn;

    @FXML
    private TableView<?> editarFamilia_tablaSocios;

    @FXML
    private TableColumn<?, ?> editarFamilia_tablaSociosSocioID;

    @FXML
    private TableColumn<?, ?> editarFamilia_tablaSociosNombre;

    @FXML
    private TableColumn<?, ?> editarFamilia_tablaSociosApellido;

    @FXML
    private AnchorPane familias_tablaVistaConceptos;

    @FXML
    private Button editarFamilia_agregarConceptoBtn;

    @FXML
    private Button editarFamilia_eliminarConceptoBtn;

    @FXML
    private TableView<?> editarFamilia_tablaConceptos;

    @FXML
    private TableColumn<?, ?> editarFamilia_tablaConceptosDescripcion;

    @FXML
    private TableColumn<?, ?> editarFamilia_tablaConceptosPrecio;

    @FXML
    private Button editarFamilia_guardarBtn;
        
    // --- ELIMINAR FAMILIA ---

    @FXML
    private Button familias_eliminarBtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();
    
    
    @FXML
    void displayDeleteFamilia(ActionEvent event) {

    }

    @FXML
    void displayFormCreateFamilia(ActionEvent event) {

    }

    @FXML
    void displayFormUpdateFamilia(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    
}
