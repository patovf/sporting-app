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
    
    // EMPIEZAN SECCIONES
    
    @FXML
    private AnchorPane inicio_panel;
    
    @FXML
    private AnchorPane socios_panel;
        
    @FXML
    private AnchorPane conceptos_panel;
    
    @FXML
    private AnchorPane familias_panel;
    
    @FXML
    private AnchorPane reportes_panel;
    
    // TERMINAN SECCIONES
    
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
    private Button menu_conceptosBtn;
    
    @FXML
    private Button menu_familiasBtn;

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
         
        // PANEL INICIO
        
        FXMLLoader inicioLoader = new FXMLLoader();
        inicioLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/inicio.fxml"));
        try {
            Parent inicioRoot = inicioLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicioController inicioController = inicioLoader.getController();
        
        // PANEL SOCIOS
                     
        FXMLLoader sociosLoader = new FXMLLoader();
        sociosLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/socios.fxml"));
        try {
            Parent sociosRoot = sociosLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sociosController sociosController = sociosLoader.getController();

        // PANEL CONFIGURACIONES

        FXMLLoader conceptosLoader = new FXMLLoader();
        conceptosLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/conceptos.fxml"));
        try {
            Parent conceptosRoot = conceptosLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conceptosController conceptosController = conceptosLoader.getController();
        
        // PANEL FAMILIAS
         
        FXMLLoader familiasLoader = new FXMLLoader();
        familiasLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/familias.fxml"));
        try {
            Parent familiasRoot = familiasLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        familiasController familiasController = familiasLoader.getController();
            
        // PANEL REPORTES
         
        FXMLLoader reportesLoader = new FXMLLoader();
        reportesLoader.setLocation(getClass().getResource("/sportingapplication/resources/fxml/reportes.fxml"));
        try {
            Parent reportesRoot = reportesLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        reportesController reportesController = reportesLoader.getController();
            
        // MUESTRA DE PANELES
        
        if (event.getSource() == menu_inicioBtn) {
            inicio_panel.setVisible(true);
            socios_panel.setVisible(false);
            conceptos_panel.setVisible(false);
            familias_panel.setVisible(false);
            reportes_panel.setVisible(false);
        } else if (event.getSource() == menu_sociosBtn) {
            inicio_panel.setVisible(false);
            socios_panel.setVisible(true);
            conceptos_panel.setVisible(false);
            familias_panel.setVisible(false);
            reportes_panel.setVisible(false);
        } else if (event.getSource() == menu_conceptosBtn) {
            inicio_panel.setVisible(false);
            socios_panel.setVisible(false);
            conceptos_panel.setVisible(true);
            familias_panel.setVisible(false);
            reportes_panel.setVisible(false);
        } else if (event.getSource() == menu_familiasBtn) {
            inicio_panel.setVisible(false);
            socios_panel.setVisible(false);
            conceptos_panel.setVisible(false);
            familias_panel.setVisible(true);
            reportes_panel.setVisible(false);
        } else if (event.getSource() == menu_reportesBtn) {
            inicio_panel.setVisible(false);
            socios_panel.setVisible(false);
            conceptos_panel.setVisible(false);
            familias_panel.setVisible(false);
            reportes_panel.setVisible(true);
        }
    }
}
