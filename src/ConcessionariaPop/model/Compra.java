package ConcessionariaPop.model;
import java.util.Calendar;


public class Compra {
 private Carro veiculo;
 private Cliente cliente;
 private Calendar data;
 private int formaPagamento;
 
 public Compra(Carro veiculo, Cliente cliente, Calendar data, int formaPagamento){
     this.cliente=cliente;
     this.data=data;
     this.formaPagamento=formaPagamento;
     this.veiculo=veiculo;
 }

    public Carro getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Carro veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
 
 
 
 
 
 
}
