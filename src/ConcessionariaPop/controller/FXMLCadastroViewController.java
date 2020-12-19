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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

public class FXMLCadastroViewController implements Initializable{    
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
    @FXML
    private AnchorPane anchorPaneMain;
    @FXML
    private AnchorPane anchorPaneHome;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    @FXML
    private TableColumn<Cliente, String> colunaCidade;
    @FXML
    private TableColumn<Cliente, String> colunaLogradouro;
    @FXML
    private TableColumn<Cliente, String> colunaBairro;
    @FXML
    private TableColumn<Cliente, String> colunaNum;
    @FXML
    private TableView<Cliente> tableViewClientes;
    
    @FXML
    public void newRegister() throws Exception {   
        try{
       Cliente newCliente = new Cliente(txtNome.getText(),
                                         txtCpf.getText(),
                                         txtTelefone.getText(),
                                         new Endereco (txtLogradouro.getText(),
                                                       Integer.parseInt(txtNumero.getText()),
                                                       txtBairro.getText(),
                                                       txtCidade.getText()));
        tableViewClientes.getItems().add(newCliente);      
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");      
        lblErro.setText("");
        } catch (NullPointerException e){ //Parei aqui
            lblErro.setText("Preencha todos os campos");
        } catch (NumberFormatException ex) {
            lblErro.setText("Apenas números no campo 'Número'");
        }
        //buscarCliente();
    }
    
     
    @FXML
    public void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editTable();
        tableViewClientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selCliente(newValue));
        updateTableClientes();
        //buscarCliente();
    }
    
        ObservableList<Cliente> getClientes(){
        ObservableList<Cliente> clienteList = FXCollections.observableArrayList();
        clienteList.add(new Cliente("Dog","0876526263","(73)988751666", new Endereco("Rua x", 31, "Centro", "Vitória da Conquista")));
        return clienteList;
    }
        
        @FXML
        public void updateTableClientes(){
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaCidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getCidade()));
        colunaNum.setCellValueFactory((param) -> new SimpleStringProperty(String.valueOf(param.getValue().getEndereco().getNumero())));
        colunaBairro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getBairro()));
        colunaLogradouro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getLogradouro()));
        tableViewClientes.setItems(getClientes());
        }
   
        @FXML
        public void editTable(){
        tableViewClientes.setEditable(true);
        colunaNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaTelefone.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaCidade.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaNum.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaBairro.setCellFactory(TextFieldTableCell.forTableColumn());
        colunaLogradouro.setCellFactory(TextFieldTableCell.forTableColumn());
        }
        
        @FXML
        public void selCliente(Cliente cliente){
       
          if (cliente != null){
        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtTelefone.setText(cliente.getTelefone());
        txtBairro.setText(cliente.getEndereco().getBairro());
        txtNumero.setText(String.valueOf(cliente.getEndereco().getNumero()));
        txtLogradouro.setText(cliente.getEndereco().getLogradouro());
        txtCidade.setText(cliente.getEndereco().getCidade());
        } else {
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
            txtBairro.setText("");
            txtNumero.setText("");
            txtLogradouro.setText("");
            txtCidade.setText("");
        }
    }
        
    @FXML
    public void delClienteSelect(){
        ObservableList<Cliente> selectedRows, allCliente;
        allCliente = tableViewClientes.getItems();
        selectedRows = tableViewClientes.getSelectionModel().getSelectedItems();
        
        for(Cliente cliente: selectedRows){
            allCliente.remove(cliente);
        }

        //buscarCliente();
    }
 
    @FXML
    public void buscarCliente(){
    updateTableClientes();     
    
    FilteredList<Cliente> filteredData = new FilteredList<>(getClientes(), b -> true);  
    txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredData.setPredicate(clientePesquisa -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (clientePesquisa.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (clientePesquisa.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else  
          return false; // Does not match.
   });
  });  
    SortedList<Cliente> sortedData = new SortedList<>(filteredData);  
    sortedData.comparatorProperty().bind(tableViewClientes.comparatorProperty());  
    tableViewClientes.setItems(sortedData);      
  }
}
    
