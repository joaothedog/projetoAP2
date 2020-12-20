package ConcessionariaPop.model;

import javafx.beans.property.SimpleStringProperty;

public class Endereco {
  private int numero;
  private SimpleStringProperty cidade, logradouro, bairro;
  
  public Endereco(String logradouro, int numero, String bairro, String cidade){
    this.bairro= new SimpleStringProperty(bairro);
    this.cidade= new SimpleStringProperty(cidade);
    this.numero= numero;
    this.logradouro= new SimpleStringProperty(logradouro);    
  }

    public Endereco(){}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade.get();
    }

    public void setCidade(SimpleStringProperty cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro.get();
    }

    public void setLogradouro(SimpleStringProperty logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro.get();
    }

    public void setBairro(SimpleStringProperty bairro) {
        this.bairro = bairro;
    }


  
  
}
