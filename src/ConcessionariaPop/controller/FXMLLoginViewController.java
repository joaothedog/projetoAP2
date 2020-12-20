package ConcessionariaPop.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class FXMLLoginViewController implements Initializable {
    
    @FXML
    private Label lblStatus;

    @FXML
    private JFXTextField JFXTextField;

    @FXML
    private JFXPasswordField JFXPasswordField;
    
    
    @FXML
    public void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }
    
    public void error(){
        Notifications notification = Notifications.create();
        notification.title("Erro de credenciais");
        notification.text("Login ou senha incorretos");
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }
    
    public void check(){
        Notifications notification = Notifications.create();
        notification.title("Sucesso");
        notification.text("Logado com sucesso, seja bem-vindo " + JFXTextField.getText());
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }
    public void loginNew(MouseEvent event) throws Exception {
    if (JFXTextField.getText().equals("admin") && JFXPasswordField.getText().equals("pass")) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/MainView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
        check();
    } else {
        error();
    }

}   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

