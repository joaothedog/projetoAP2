package ConcessionariaPop.model;
import java.util.ArrayList;
import java.util.List;


public class ControleCliente  {
private List<Cliente> listaCliente= new ArrayList();
    
    
    public void add(String nome, String cpf, String telefone, Endereco endereco) {
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEndereco(endereco);
        c.setTelefone(telefone);
        listaCliente.add(c);
        
        
    }
    
    
    
      public Cliente buscarCPF(String cpf){
        for( int i = 0; i<listaCliente.size(); i++){
            if(listaCliente.get(i).getNome().equals(cpf)){
                return listaCliente.get(i);
            }
            
        }

        return null;

        

    }

    public void add(Cliente cliente) {
        listaCliente.add(cliente);
    }
}
