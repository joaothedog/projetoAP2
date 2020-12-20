package ConcessionariaPop.model;

import java.util.Date;

public class Compra {
    private Carro veiculo;
    private Cliente cliente;
    private Date data;
    private String formaPagamento;
 
 public Compra(Carro veiculo, Cliente cliente, Date data, String formaPagamento){
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
 
 
 
 
 
 
}
