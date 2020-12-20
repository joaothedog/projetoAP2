package ConcessionariaPop.model;

public class CarroSemiNovo extends Carro{
    private int kmRodado;   
    
    public CarroSemiNovo(int ano, String modelo, String marca, double preco,int kmRodado, String cor){
        super(ano,modelo, marca, preco, cor);
        this.kmRodado=kmRodado;
    }
    
    
   public void setKmRodado(int kmRodado){
        this.kmRodado=kmRodado;
    }
    
}
