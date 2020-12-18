package ConcessionariaPop.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class FXMLMainViewController implements Initializable {

    private AnchorPane anchorpane;
    @FXML
    private AnchorPane anchorPaneMain;
    @FXML
    private AnchorPane anchorPaneHome;
  
    @FXML
    public void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }
    public void mostraHome(MouseEvent event) throws IOException {
        handleLoadHome();
    }
    
    private void handleLoadHome() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/HomeView.fxml"));
        anchorpane.getChildren().setAll(root);
    }
    
    public void mostraCadastro(MouseEvent event) throws IOException {
        handleLoadCadastro();
    }
    
    private void handleLoadCadastro() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/CadastroView.fxml"));
        anchorpane.getChildren().setAll(root);
    }
    
    public void mostraSobreNos(MouseEvent event) throws IOException {
        handleLoadSobreNos();
    }
    
    private void handleLoadSobreNos() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/SobreNosView.fxml"));
        anchorpane.getChildren().setAll(root);
    }
    
    public void mostraCadastroCarro(MouseEvent event) throws IOException {
        handleLoadCadastroCarro();
    }
    
    private void handleLoadCadastroCarro() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/CadastroCarroView.fxml"));
        anchorpane.getChildren().setAll(root);
    }
    public void mostraAgendamento(MouseEvent event) throws IOException {
        handleLoadAgendamento();
    }
    
    private void handleLoadAgendamento() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ConcessionariaPop/view/AgendamentoView.fxml"));
        anchorpane.getChildren().setAll(root);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    
    
}
