package ConcessionariaPop.controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import ConcessionariaPop.model.Carro;
import ConcessionariaPop.model.CarroNovo;
import ConcessionariaPop.model.CarroSemiNovo;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXMLCadastroCarroViewController implements Initializable {
    //declarações dentro do fxml

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private AnchorPane anchorPaneMain;
    @FXML
    private AnchorPane anchorPaneHome;
    @FXML
    private Label lblEstoque_km;
    @FXML
    private JFXTextField txtModelo;
    @FXML
    private JFXTextField txtKm_Estoque;
    @FXML
    private JFXToggleButton tBtnNovo;
    @FXML
    private JFXTextField txtAno;
    @FXML
    private JFXTextField txtMarca;
    @FXML
    private JFXTextField txtPreco;
    @FXML
    private JFXComboBox<String> comboBoxCor = new JFXComboBox();
    //declarações fora do fxml
    private ArrayList<Carro> carros= new ArrayList();
    private ObservableList<String> cores;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarCores();
    }
    //método para colocar as cores no combo box
    public void carregarCores(){
        cores = FXCollections.observableArrayList("Preto","Cinza","Branco","Vermelho");
        comboBoxCor.setItems(cores);
    }
    //método para encerrar o programa
    @FXML
    private void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }
    //Usa o toggle button para alterar na GUI o nome do texto Kms Rodados/Estoque
    @FXML
    private void mudarKm_Estoque(ActionEvent event) {
        if(lblEstoque_km.getText().equals("KMs Rodados"))
            lblEstoque_km.setText("Estoque");
        else
            lblEstoque_km.setText("KMs Rodados");        
    }
    //método para adicionar um carro ao array list carros após precionar o botão "+"
    @FXML
    private void addCarro(ActionEvent event) {
        try{
            txtModelo.getText();
            int ano, km_estoque;
            double preco;
            //transforma os tipo String nos tipos usado pelo programa
            preco=Double.parseDouble(txtPreco.getText());
            ano=Integer.parseInt(txtAno.getText());
            km_estoque=Integer.parseInt(txtKm_Estoque.getText());
            //adiciona um carro semi novo caso o campo seja igual a "KMs Rodados"
            if(lblEstoque_km.getText().equals("KMs Rodados"))
                carros.add(new CarroSemiNovo(ano, txtModelo.getText(), txtMarca.getText(), preco, km_estoque, comboBoxCor.getValue()));
            //adiciona um carro novo caso o campo seja igual a "Estoque"
            else
                carros.add(new CarroNovo(ano, txtModelo.getText(), txtMarca.getText(), preco, km_estoque, comboBoxCor.getValue()));
            //todas as linhas abaixo servem para resetar os campos
            txtModelo.setText("");
            txtMarca.setText("");
            txtAno.setText("");
            txtPreco.setText("");
            txtKm_Estoque.setText("");
            comboBoxCor.setValue("");
        }
        //exceção para caso os campos ano, preço e kilometros/estoque não possuam somente números
        catch(NumberFormatException e){
            
        }
    }
   
}
