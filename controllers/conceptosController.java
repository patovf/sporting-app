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

/**
 *
 * @author Paulina Vaira
 */
public class conceptosController implements Initializable {
    
    // --- TABLA DE CONCEPTOS ---
    
    @FXML
    private AnchorPane conceptos_panel;

    @FXML
    private AnchorPane conceptos_filtros;

    @FXML
    private TextField conceptos_filtroNombre;

    @FXML
    private AnchorPane conceptos_tablaVista;

    @FXML
    private TableView<Concepto> conceptos_tabla;

    @FXML
    private TableColumn<Concepto, String> conceptos_tablaNombre;

    @FXML
    private TableColumn<Concepto, String> conceptos_tablaDescripcion;
    
    @FXML
    private Button conceptos_agregarBtn;
    
    // --- AGREGAR CONCEPTO ---
    
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
    
    // --- EDITAR CONCEPTO ---
    
        @FXML
    private Button conceptos_editarBtn;
        
    // --- ELIMINAR CONCEPTO ---

    @FXML
    private Button conceptos_eliminarBtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    //private AlertMessage alert = new AlertMessage();

    public ObservableList<Concepto> getConceptos() {
        ObservableList<Concepto> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM concepto";
        
        Concepto concepto;

        try {
            connect = database.connectDB();
        
            prepare = connect.prepareStatement(query);
            result = prepare.executeQuery();
            
            while(result.next()) {
                concepto = new Concepto(result.getInt("id"),
                result.getString("name"),
                result.getString("description"),
                result.getDouble("price"),
                result.getBoolean("active"),
                result.getDate("created_at"),
                result.getDate("modified_at"));
                        
                list.add(concepto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    private ObservableList<Concepto> conceptoList;
    
    public void displayConceptos() {
        try {
            conceptoList = getConceptos();
        
            conceptos_tablaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
            conceptos_tablaDescripcion.setCellValueFactory(new PropertyValueFactory<>("description"));

            conceptos_tabla.setItems(conceptoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    *
    *   AGREGAR CONCEPTO
    *
    */
    
    public void displayFormCreateConcepto() {
        try {
            System.out.print("click crear concepto");
            Parent root = FXMLLoader.load(getClass().getResource("/sportingapplication/resources/fxml/agregarConcepto.fxml"));
        
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
    public void createConcepto() {
        try {
            String query = "INSERT INTO concepto (name, description, price, active) VALUES (?, ?, ?, ?)";
                    
            connect = database.connectDB();
            prepare = connect.prepareStatement(query);

            prepare.setString(1, nuevoConcepto_nombre.getText());
            prepare.setString(2, nuevoConcepto_descripcion.getText());
            prepare.setDouble(3, Double.parseDouble(nuevoConcepto_costo.getText()));
            prepare.setBoolean(4, true);
            
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            displayConceptos();
    }
    
    
    
}
