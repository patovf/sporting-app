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
public class reportesController implements Initializable {
    
    // --- TABLA DE REPORTES ---
    
    @FXML
    private AnchorPane reportes_panel;

    @FXML
    private AnchorPane reportes_panel_sec;

    @FXML
    private AnchorPane reportes_filtros;

    @FXML
    private TextField reportes_filtroNombre;

    @FXML
    private AnchorPane reportes_tablaVista;

    @FXML
    private TableView<?> reportes_tabla;

    @FXML
    private TableColumn<?, ?> reportes_tablaSocioId;

    @FXML
    private TableColumn<?, ?> reportes_tablaNombre;

    @FXML
    private TableColumn<?, ?> reportes_tablaApellido;

    @FXML
    private TableColumn<?, ?> reportes_tablaSede;

    @FXML
    private Button reportes_exportarRecibosBtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();
    
    @FXML
    void exportRecibos(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
