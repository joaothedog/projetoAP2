package ConcessionariaPop.controller;

import ConcessionariaPop.model.Carro;
import ConcessionariaPop.model.CarroNovo;
import ConcessionariaPop.model.CarroSemiNovo;
import ConcessionariaPop.model.Cliente;
import ConcessionariaPop.model.Compra;
import ConcessionariaPop.model.Endereco;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author dog
 */
public class FXMLAgendamentoViewController implements Initializable{

    @FXML
    private AnchorPane anchorPaneMain;
    @FXML
    private AnchorPane anchorPaneHome;
    @FXML
    private JFXTextField txtCPF;
    @FXML
    private JFXTextField txtCarro;
    @FXML
    private JFXComboBox<String> cbFormaPagamento;
    @FXML
    private Label lblCampoVazio;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private TableView<Carro> tableViewCarro;
    @FXML
    private TableColumn<Carro, String> colummModelo;
    @FXML
    private TableColumn<Carro, String> colummMarca;
    @FXML
    private TableColumn<Carro, String> colummAno;
    @FXML
    private TableColumn<Carro, String> colummStatus;
    @FXML
    private TableColumn<Carro, String> colummEstoque;
    @FXML
    private TableColumn<Carro, String> colummKMsRodados;
    @FXML
    private TableColumn<Carro, String> colummPreco;
    //Declarações fora do FXML
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Carro> carros = new ArrayList();
    private ArrayList<Compra> compras = new ArrayList();
    
    private ObservableList<Carro> obsCarros;
    private ObservableList<String> obsFormasPagamento;
    
    private Carro carroSelecionado;

    @FXML
    private void handleCloseWindow(MouseEvent event) {
        System.exit(0);
    }

    private void carregarCarroTableView(){
        colummModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colummMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colummAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colummPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        //colummModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        
        Carro c1 = new CarroNovo(2019, "Modelo X", "Marca X", 50000, 2, "Vermelho");
        Carro c2 = new CarroNovo(2019, "Modelo Z", "Marca X", 50000, 2, "Vermelho");
        Carro c3 = new CarroSemiNovo(2019, "Modelo C", "Marca X", 50000, 2, "Vermelho");
        Carro c4 = new CarroNovo(2019, "Modelo V", "Marca X", 50000, 2, "Vermelho");
        Carro c5 = new CarroSemiNovo(2019, "Modelo B", "Marca X", 50000, 2, "Vermelho");
        Carro c6 = new CarroSemiNovo(2019, "Modelo N", "Marca X", 50000, 2, "Vermelho");
        Carro c7 = new CarroNovo(2019, "Modelo M", "Marca X", 50000, 2, "Vermelho");
        
        carros.add(c1);
        carros.add(c2);
        carros.add(c3);
        carros.add(c4);
        carros.add(c5);
        carros.add(c6);
        carros.add(c7);
        
        obsCarros = FXCollections.observableArrayList(carros);
        
        tableViewCarro.setItems(obsCarros);
        
        obsFormasPagamento = FXCollections.observableArrayList("A Vista", "Entrada + Parcelas");
        cbFormaPagamento.setItems(obsFormasPagamento);
        
    }
    
    private Cliente buscaClienteCpf() {
            for(Cliente c : clientes){
                if (c.getCpf().equals(txtCPF.getText()))
                    return c;
            }
        return null;
    }

    @FXML
    private void add(ActionEvent event) {
        Cliente cliente = buscaClienteCpf();
        //carroSelecionado
        //System.out.println(carroSelecionado.getModelo());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarCarroTableView();
        Endereco end = null;
        clientes.add(new Cliente("Alan", "122", "515151", end));
        tableViewCarro.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarTableCarro(newValue));
    }  
    
    public void selecionarTableCarro(Carro carro){
        txtCarro.setText(carro.getModelo() + ", " + carro.getMarca() + ", " + carro.getAno());
        carroSelecionado=carro;
    }
}