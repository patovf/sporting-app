/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package sportingapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Paulina Vaira
 */
public class SportingApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sportingapplication/resources/fxml/login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Gestión Sporting Club");
        // todo: ver si sirve para el jar entregado
        stage.getIcons().add(new Image("/sportingapplication/resources/utils/escudo_sporting.png"));
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
