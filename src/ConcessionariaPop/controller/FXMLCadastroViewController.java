package ConcessionariaPop.controller;

import ConcessionariaPop.model.Cliente;
import ConcessionariaPop.model.Endereco;
import ConcessionariaPop.model.exceptions.ObjetoInexistenteException;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    private ObservableList<Cliente> clientList = FXCollections.observableArrayList();
    
    @FXML
    public void newRegister() throws Exception {   
        try{
            Cliente newCliente = new Cliente(txtNome.getText(), txtCpf.getText(), txtTelefone.getText(),
                 new Endereco (txtLogradouro.getText(), Integer.parseInt(txtNumero.getText()), txtBairro.getText(), txtCidade.getText()));

            tableViewClientes.getItems().add(newCliente);
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
            txtLogradouro.setText("");
            txtNumero.setText("");
            txtBairro.setText("");
            txtCidade.setText("");      
            lblErro.setText("");
            
            updateTableClients();
        } catch (NullPointerException e){ 
            lblErro.setText("Preencha todos os campos");
        } catch (NumberFormatException ex) {
            lblErro.setText("Apenas números no campo 'Número'");
        }
    }
    
    @FXML
    public void updateTableClients(){
        tableViewClientes.setItems(clientList);
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
    public void onEditName(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.setNome(clientStringEditEvent.getNewValue());
    }
        
    @FXML
    public void onEditCpf(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.setCpf(clientStringEditEvent.getNewValue());
    }
        
    @FXML
    public void onEditTelefone(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.setTelefone(clientStringEditEvent.getNewValue());
    }
        
    @FXML
    public void onEditCidade(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.getEndereco().setCidade(new SimpleStringProperty(clientStringEditEvent.getNewValue()));
    }
        
    @FXML
    public void onEditLogradouro(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.getEndereco().setLogradouro(new SimpleStringProperty(clientStringEditEvent.getNewValue()));
    }
        
    @FXML
    public void onEditBairro(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.getEndereco().setBairro(new SimpleStringProperty(clientStringEditEvent.getNewValue()));
    }
        
    @FXML
    public void onEditNum(TableColumn.CellEditEvent<Cliente, String> clientStringEditEvent){
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        cliente.getEndereco().setNumero(Integer.parseInt(clientStringEditEvent.getNewValue()));
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
        ObservableList<Cliente> selectedRows;
        selectedRows = tableViewClientes.getSelectionModel().getSelectedItems();
        
        for(Cliente cliente: selectedRows){
            clientList.remove(cliente);
        }

        updateTableClients();
    }
 
    @FXML
    public void searchClient (MouseEvent event) throws Exception{
        String cpf = txtPesquisar.getText();
        boolean isFind = false;     // gambiarra ou preguiça?
         
        for (Cliente cliente: clientList)
            if (cliente.getCpf().equals(cpf)){
                isFind = true;
                tableViewClientes.setItems(FXCollections.observableArrayList(cliente));
            }
        
        if (!isFind){
            updateTableClients();
            throw new ObjetoInexistenteException("Cliente inexistente.");
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientList.add(new Cliente("Dog","0876526263","(73)988751666", new Endereco("Rua x", 31, "Centro", "Vitória da Conquista")));
        clientList.add(new Cliente("Crisao","07720321590","(73)988751666", new Endereco("Rua x", 31, "Centro", "Vitória da Conquista")));
        clientList.add(new Cliente("Careca","0899526263","(73)988751666", new Endereco("Rua x", 31, "Centro", "Vitória da Conquista")));
        
        editTable();
        
        tableViewClientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selCliente(newValue));
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaCidade.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getCidade()));
        colunaNum.setCellValueFactory((param) -> new SimpleStringProperty(String.valueOf(param.getValue().getEndereco().getNumero())));
        colunaBairro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getBairro()));
        colunaLogradouro.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEndereco().getLogradouro()));
        
        updateTableClients();
    }
        
    @FXML
    public void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }
}
