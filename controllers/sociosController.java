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
import sportingapplication.models.Socio;
import sportingapplication.models.dto.ConceptoDto;
import sportingapplication.models.dto.SocioDto;

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
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    
    private AlertMessage alert = new AlertMessage();
    
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
                result.getInt("family_id"),
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
                socios_tablaNombre.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                socios_tablaApellido.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                socios_tablaFechaAlta.setCellValueFactory(new PropertyValueFactory<>("registratedAt"));
                
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
            String query = "INSERT INTO socio (socioId, firstname, lastname, sede, familyId, registratedAt, active) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    
            connect = database.connectDB();
            prepare = connect.prepareStatement(query);

            // TODO: AGREGAR PROPIEDADES FALTANTES
            
            prepare.setString(1, nuevoSocio_nombre.getText());
            prepare.setString(2, nuevoSocio_apellido.getText());
            prepare.setString(3, nuevoSocio_sede.getText());
            prepare.setBoolean(4, true);
            
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
    
//    public void editSocio() {
//        try {
//            if (alert.confirmMessage("Está seguro de que desea editar este socio?")) {
//                String query = "UPDATE socio SET firstname = '" + editarConcepto_nombre.getText() + "', "
//                    + "description = '" + editarConcepto_descripcion.getText() + "', "
//                    + "price = " + editarConcepto_costo.getText() + " "
//                    + "WHERE id = " + ConceptoDto.id + "";
//                
//                System.out.println(query);
//                    
//                connect = database.connectDB();
//                prepare = connect.prepareStatement(query);
//            
//                prepare.executeUpdate();
//                
//                alert.successMessage("Concepto editado correctamente!");
//                
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    /*
    *
    *   ELIMINAR CONCEPTO
    *
    */
    
    public void displayDeleteConcepto() {
        try {
            Concepto concepto = conceptos_tabla.getSelectionModel().getSelectedItem();
            int num = conceptos_tabla.getSelectionModel().getSelectedIndex();
            
            if (concepto != null) {
                if ((num - 1) < -1) {
                    alert.errorMessage("Debe seleccionar la fila a eliminar");
                    return;
                } else {
                    ConceptoDto.id = concepto.getId();
                    ConceptoDto.name = concepto.getName();
                    ConceptoDto.description = concepto.getDescription();
                    ConceptoDto.price = concepto.getPrice();
                    
                deleteConcepto();
                }
            } else {
                alert.errorMessage("Debe seleccionar la fila a eliminar");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteConcepto() {
        try {
            if (alert.confirmMessage("Está seguro de que desea eliminar este concepto?")) {
                String query = "UPDATE concepto SET active = ? WHERE id = ?";
                connect = database.connectDB();
                prepare = connect.prepareStatement(query);
            
                prepare.setString(1, String.valueOf(0));
                prepare.setString(2, String.valueOf(ConceptoDto.id));
                
                prepare.executeUpdate();
                
                alert.successMessage("Concepto eliminado correctamente!");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setData() {
        try {        
            String query = "SELECT * FROM concepto WHERE id = " + ConceptoDto.id + ";";
        
            Concepto concepto;

            connect = database.connectDB();
        
            prepare = connect.prepareStatement(query);
            result = prepare.executeQuery();
            
            if (result.next()) {
                editarConcepto_id.setText(result.getString("id"));
                editarConcepto_nombre.setText(result.getString("name"));
                editarConcepto_descripcion.setText(result.getString("description"));
                editarConcepto_costo.setText(result.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayFormDeleteConcepto() {
        try {

        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            displayConceptos();
            setData();
    }

}
