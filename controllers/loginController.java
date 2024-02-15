/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package sportingapplication.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sportingapplication.config.database;

/**
 *
 * @author Paulina Vaira
 */
public class loginController implements Initializable {

    @FXML
    private AnchorPane si_panel;

    // todo: averiguar sobre ruta de imagen
    @FXML
    private ImageView si_logo;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private TextField si_username;

    @FXML
    private Button si_loginBtn;

    @FXML
    private PasswordField si_password;

    // db connection
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;
    
    private double x = 0;
    private double y = 0;

    public void showAlert(AlertType type, String title, String headerText, String contentText) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void loginBtn() {
        if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Error", null, "Usuario/Contraseña incorrecto");
        } else {
            String selectUser = "SELECT * FROM user_account WHERE username = ? AND password = ?";
            
            // busco usuario
            try {
                connect = database.connectDB();

                prepare = connect.prepareStatement(selectUser);
                prepare.setString(1, si_username.getText());
                prepare.setString(2, si_password.getText());

                result = prepare.executeQuery();
            
                if (result.next()) {
                    showAlert(AlertType.INFORMATION, "Éxito", null, "Inicio de sesión exitoso!");
                    
                    si_loginBtn.getScene().getWindow().hide();
                    
                    Parent root = FXMLLoader.load(getClass().getResource("/sportingapplication/resources/fxml/dashboard.fxml"));
                    
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                } else {
                    showAlert(AlertType.ERROR, "Error", null, "Usuario/Contraseña incorrecto");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
