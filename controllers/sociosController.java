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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import sportingapplication.models.AlertMessage;
import sportingapplication.models.Concepto;
import sportingapplication.models.Sede;
import sportingapplication.models.Socio;
import sportingapplication.models.dto.ConceptoDto;
import sportingapplication.models.dto.SocioDto;

/**
 *
 * @author Paulina Vaira
 */
public class sociosController implements Initializable {
    
    @FXML
    private AnchorPane socios_panel;

    @FXML
    private AnchorPane socios_filtros;

    @FXML
    private TextField socios_filtroNombre;

    @FXML
    private AnchorPane socios_tablaVista;

    @FXML
    private TableView<Socio> socios_tabla;

    @FXML
    private TableColumn<Socio, String> socios_tablaSocioId;

    @FXML
    private TableColumn<Socio, String> socios_tablaNombre;

    @FXML
    private TableColumn<Socio, String> socios_tablaApellido;

    @FXML
    private TableColumn<Socio, String> socios_tablaSede;

    @FXML
    private Button socios_agregarBtn;

    @FXML
    private Button socios_editarBtn;


    // --- AGREGAR SOCIO ---
    
    @FXML
    private TextField nuevoSocio_nombre;

    @FXML
    private TextField nuevoSocio_apellido;

    @FXML
    private Button nuevoSocio_crearBtn;

    @FXML
    private Button nuevoSocio_cancelarBtn;

    @FXML
    private TextField nuevoSocio_socioId;

    @FXML
    private ComboBox<String> nuevoSocio_sede;
    
    // --- EDITAR SOCIO ---
    
    @FXML
    private TextField editarSocio_nombre;

    @FXML
    private TextField editarSocio_apellido;

    @FXML
    private Button editarSocio_editarBtn;

    @FXML
    private Button editarSocio_cancelarBtn;

    @FXML
    private TextField editarSocio_socioId;

    @FXML
    private ComboBox<String> editarSocio_sede;
    
    // --- ELIMINAR SOCIO ---
    
    @FXML
    private Button socios_eliminarBtn;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    
    private AlertMessage alert = new AlertMessage();
    
    public void imprimirRecibo() {
        
    }
   
    public void switchToSocios(boolean value) {
        try {
            System.out.println("asd");
            socios_panel.setVisible(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<Socio> getSocios() {
        ObservableList<Socio> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM socio WHERE active = ?";
        
        Socio socio;

        try {
            connect = database.connectDB();
        
            prepare = connect.prepareStatement(query);
            prepare.setString(1, String.valueOf(1));
            result = prepare.executeQuery();
            
            list.clear();
            
            while(result.next()) {
                socio = new Socio(result.getInt("id"),
                result.getInt("socio_id"),
                result.getString("firstname"),
                result.getString("lastname"),
                result.getString("sede"),
                result.getBoolean("active"),
     result.getDate("registrated_at"),
                result.getDate("created_at"),
                result.getDate("modified_at"));
                        
                list.add(socio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    private ObservableList<Socio> socioList;
    
    public void displaySocios() {
        try {
            socioList = getSocios();
        
            if (socios_tablaNombre != null) {
                socios_tablaSocioId.setCellValueFactory(new PropertyValueFactory<>("socioId"));
                socios_tablaNombre.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                socios_tablaApellido.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                socios_tablaSede.setCellValueFactory(new PropertyValueFactory<>("sede"));
                
                socios_tabla.setItems(socioList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    *
    *   AGREGAR CONCEPTO
    *
    */
    
    public void displayFormCreateSocio() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sportingapplication/resources/fxml/agregarSocio.fxml"));
        
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
    public void createSocio() {
        try {
            String query = "INSERT INTO socio (socio_id, firstname, lastname, registrated_at, active) VALUES (?, ?, ?, ?, ?)";
                    
            connect = database.connectDB();
            prepare = connect.prepareStatement(query);
            
            Date date = new Date();

            // TODO: AGREGAR SEDE (LISTA)
            prepare.setString(1, nuevoSocio_socioId.getText());            
            prepare.setString(2, nuevoSocio_nombre.getText());
            prepare.setString(3, nuevoSocio_apellido.getText());
            prepare.setString(4, nuevoSocio_sede.getSelectionModel().getSelectedItem());
//            prepare.setString(5, date.);
            prepare.setBoolean(5, true);
            
            prepare.executeUpdate();

            alert.successMessage("Socio creado correctamente!");
            
            socios_tabla.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    *
    *   EDITAR CONCEPTO
    *
    */
    
    public void displayFormUpdateSocio() {
        try {
            Socio socio = socios_tabla.getSelectionModel().getSelectedItem();
            int num = socios_tabla.getSelectionModel().getSelectedIndex();
            
            if (socio != null) {
                if ((num - 1) < -1) {
                    alert.errorMessage("Debe seleccionar la fila a editar");
                    return;
                } else {
                    SocioDto.id = socio.getId();
                    SocioDto.firstname = socio.getFirstname();
                    SocioDto.lastname = socio.getLastname();
                    SocioDto.sede = socio.getSede();
                
                    Parent root = FXMLLoader.load(getClass().getResource("/sportingapplication/resources/fxml/editarSocio.fxml"));
        
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
            
                    stage.show();
                    
//                    setData();
                }
            } else {
                alert.errorMessage("Debe seleccionar la fila a editar");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editSocio() {
        try {
            if (alert.confirmMessage("Está seguro de que desea editar este socio?")) {
                String query = "UPDATE socio SET firstname = '" + editarSocio_nombre.getText() + "', "
                    + "lastname = '" + editarSocio_apellido.getText() + "', "
                    + "sede = " + editarSocio_sede.getSelectionModel().getSelectedItem() + " "
                    + "WHERE id = " + SocioDto.id + "";
                
                System.out.println(query);
                    
                connect = database.connectDB();
                prepare = connect.prepareStatement(query);
            
                prepare.executeUpdate();
                
                alert.successMessage("Socio editado correctamente!");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    *
    *   ELIMINAR CONCEPTO
    *
    */
    
    public void displayDeleteSocio() {
        try {
            Socio socio = socios_tabla.getSelectionModel().getSelectedItem();
            int num = socios_tabla.getSelectionModel().getSelectedIndex();
            
            if (socio != null) {
                if ((num - 1) < -1) {
                    alert.errorMessage("Debe seleccionar la fila a eliminar");
                    return;
                } else {
                    SocioDto.id = socio.getId();
                    SocioDto.firstname = socio.getFirstname();
                    SocioDto.lastname = socio.getLastname();
                    SocioDto.sede = socio.getSede();
                    
                deleteSocio();
                }
            } else {
                alert.errorMessage("Debe seleccionar la fila a eliminar");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteSocio() {
        try {
            if (alert.confirmMessage("Está seguro de que desea eliminar este socio?")) {
                String query = "UPDATE socio SET active = ? WHERE id = ?";
                connect = database.connectDB();
                prepare = connect.prepareStatement(query);
            
                prepare.setString(1, String.valueOf(0));
                prepare.setString(2, String.valueOf(SocioDto.id));
                
                prepare.executeUpdate();
                
                alert.successMessage("Socio eliminado correctamente!");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setData() {
        try {        
            String query = "SELECT * FROM socio WHERE id = " + SocioDto.id + ";";
        
            Socio socio;

            connect = database.connectDB();
        
            prepare = connect.prepareStatement(query);
            result = prepare.executeQuery();
            
            if (result.next()) {
                editarSocio_socioId.setText(result.getString("id"));
                editarSocio_nombre.setText(result.getString("firstname"));
                editarSocio_apellido.setText(result.getString("lastname"));
                editarSocio_sede.getSelectionModel().select(result.getString("sede"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sedeList() {
        List<String> list = new ArrayList<>();
        
        for (String data: Sede.sede) {
            list.add(data);
        }
        
        ObservableList listData = FXCollections.observableArrayList(list);
        //nuevoSocio_sede.setItems(listData);
        //editarSocio_sede.setItems(listData);
    }
    
    public void displayFormDeleteConcepto() {
        try {

        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            sedeList();
            displaySocios();
            setData();
    }

}
