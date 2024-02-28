/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportingapplication.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Paulina Vaira
 */
public class dashboardController implements Initializable {
    
    @FXML
    private AnchorPane ventanaApp;
    
    @FXML
    private AnchorPane menu_barraSuperior;

    @FXML
    private ImageView menu_barraLogo;

    @FXML
    private Button menu_cerrarApp;

    @FXML
    private Button menu_minimizarApp;

    @FXML
    private Label menu_barraTitulo;

    @FXML
    private AnchorPane menu_panel;

    @FXML
    private ImageView menu_logo;

    @FXML
    private Label menu_bienvenido;

    @FXML
    private Label menu_nombreUsuario;

    @FXML
    private Button menu_cerrarSesion;

    @FXML
    private Line menu_separador;

    @FXML
    private Button menu_inicioBtn;

    @FXML
    private Button menu_sociosBtn;

    @FXML
    private Button menu_configuracionesBtn;

    @FXML
    private Button menu_reportesBtn;

    public void close() {
        System.exit(0);
    }
    
    public void minimize() {
        Stage stage = (Stage) ventanaApp.getScene().getWindow();
        stage.setIconified(true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void switchForm(ActionEvent event) {
         System.out.println("caoigo 1");
         
         // PANEL INICIO
         
         // PANEL CONFIGURACIONES
                     
            FXMLLoader sociosLoader = new FXMLLoader();
            sociosLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/socios.fxml"));
             try {
                 Parent sociosRoot = sociosLoader.load();
             } catch (IOException ex) {
                 Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
             }
            sociosController sociosController = sociosLoader.getController();
            System.out.print("click socios");
            
            

         // PANEL SOCIOS

                     
            FXMLLoader conceptosLoader = new FXMLLoader();
            conceptosLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/conceptos.fxml"));
             try {
                 Parent conceptosRoot = conceptosLoader.load();
             } catch (IOException ex) {
                 Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
             }
            conceptosController conceptosController = conceptosLoader.getController();
            System.out.print("click conceptos");
            
         
        if (event.getSource() == menu_inicioBtn) {
            System.out.print("click inicio");
            
        } else if (event.getSource() == menu_sociosBtn) {
            sociosController.switchToSocios(true);
            conceptosController.switchToConceptos(false);
        } else if (event.getSource() == menu_configuracionesBtn) {
            sociosController.switchToSocios(false);
            conceptosController.switchToConceptos(true);
            
        } else if (event.getSource() == menu_reportesBtn) {
            
            System.out.print("click reportes");
        }
    }
}
