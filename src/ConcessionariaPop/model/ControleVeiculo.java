package ConcessionariaPop.model;

import java.util.ArrayList;
import java.util.List;


public class ControleVeiculo{
	private List<Carro> listaCarro= new ArrayList();

	
    public void add(Carro carro) {
        listaCarro.add(carro);
    } 
    
    public void add(int ano, String modelo, String marca, double preco, int qntEstoque, String cor) {
       	listaCarro.add(new CarroNovo(ano,modelo,marca,preco,qntEstoque, cor));
    }
    
    public void add(int ano, String modelo, String marca,int kmRodado, double preco, String cor) {
        listaCarro.add(new CarroNovo(ano,modelo,marca,preco,kmRodado,cor));
    } 
}
