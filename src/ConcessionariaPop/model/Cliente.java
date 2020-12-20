package ConcessionariaPop.model;
public class Cliente{
private String nome;
private String cpf;
private String telefone;
private Endereco endereco;



public Cliente(){}

public Cliente(String nome, String cpf, String telefone, Endereco endereco){
    this.nome=nome;
    this.cpf=cpf;
    this.telefone=telefone;
    this.endereco=endereco;
}


public String imprimir(){
    String x= " Nome: " + getNome() + "/n CPF : " + getCpf() + "/n Telefone: " + getTelefone() + "/n Endereco: " + getEndereco()+"";
    return x;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
