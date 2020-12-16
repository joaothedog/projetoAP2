package ConcessionariaPop.model;

public class CarroSemiNovo extends Carro{
    private int kmRodado;   
    
    public CarroSemiNovo(int ano, String modelo, String marca, double preco,int kmRodado){
        super(ano,modelo, marca, preco);
        this.kmRodado=kmRodado;
    }
    
    
   public void setKmRodado(int kmRodado){
        this.kmRodado=kmRodado;
    }
    
}
