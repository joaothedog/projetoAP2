package ConcessionariaPop.model;
public class Endereco {
  private String logradouro;
  private int numero;
  private String bairro;
  private String cidade;
  
  public Endereco(String logradouro, int numero, String bairro, String cidade){
    this.bairro=bairro;
    this.cidade=cidade;
    this.numero=numero;
    this.logradouro=logradouro;
      
  }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
  
  
}
