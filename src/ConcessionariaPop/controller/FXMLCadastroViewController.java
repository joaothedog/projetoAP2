package ConcessionariaPop.controller;

import ConcessionariaPop.model.Cliente;
import ConcessionariaPop.model.Endereco;
import ConcessionariaPop.model.exceptions.CampoVazioException;
import ConcessionariaPop.controller.utils.Alerts;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class FXMLCadastroViewController implements Initializable{
    private List<Cliente> clientes = new ArrayList<>();
    
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private JFXTextField txtLogradouro;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtPesquisar;
    @FXML
    private Label lblErro;
    
    public void newRegister(MouseEvent event) throws Exception {   
        try{
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            String logradouro = txtLogradouro.getText();
            int numero = Integer.parseInt(txtNumero.getText());
            String bairro = txtBairro.getText();
            String cidade = txtCidade.getText();
        
            clientes.add(new Cliente(nome, cpf, telefone, new Endereco(logradouro, numero, bairro, cidade)));
        } catch (NullPointerException e){ //Parei aqui
            lblErro.setText("Preencha todos os campos");
        }
    }
    
    // ainda não está completo por causa da tableview
    public Cliente buscarCpf() {
        String cpf = txtPesquisar.getText();
        for(Cliente cliente: clientes)
            if (cliente.getCpf().equals(cpf))
                return cliente;
        
        throw new CampoVazioException("Cliente Inexistente", txtPesquisar);
    }
  
    public void deletarPorCpf(MouseEvent event) throws Exception {
        try{
            lblErro.setText("");
            Cliente cliente = buscarCpf();
            Optional<ButtonType> confirmação = Alerts.showConfirmation("Remover cliente", "Tem certeza que deseja remover o cliente "
                    + cliente.getNome() + "?");

            if (confirmação.get().equals(ButtonType.OK)){
                clientes.remove(cliente);
                txtPesquisar.setText("");
            }
        } catch (CampoVazioException e){
            lblErro.setText(e.getMessage());
        }
        
    }
    
    public void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Teste 
        Cliente c1 = new Cliente("Cris", "01654222", "12345678", new Endereco("Rua x", 21, "Centro", "City"));
        Cliente c2 = new Cliente("Alan", "066103215", "12345678", new Endereco("Rua x", 21, "Centro", "City"));
        Cliente c3 = new Cliente("Jao", "99872234", "12345678", new Endereco("Rua x", 21, "Centro", "City"));
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }
   
    /*
    @FXML
    void search_user() {          
        col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
        col_email.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
        col_type.setCellValueFactory(new PropertyValueFactory<users,String>("type"));
        
        dataList = mysqlconnect.getDatausers();
        table_users.setItems(dataList);
        FilteredList<users> filteredData = new FilteredList<>(dataList, b -> true);  
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
            if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
    else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter)!=-1)
         return true;// Filter matches email
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<users> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_users.comparatorProperty());  
  table_users.setItems(sortedData);   
    }
*/
}