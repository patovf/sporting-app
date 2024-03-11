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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class inicioController implements Initializable {
    
    // --- TABLA DE INICIO ---

    @FXML
    private AnchorPane inicio_panel;

    @FXML
    private AnchorPane inicio_panel_sec;

    @FXML
    private AnchorPane inicio_cabecera;

    @FXML
    private AnchorPane inicio_cuerpo;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    
}
