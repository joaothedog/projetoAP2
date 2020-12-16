package ConcessionariaPop.model;

abstract class Carro {
	protected int ano;
	protected String modelo;
	protected String marca;
	protected double preco;
        protected String cor;

	public Carro(int ano, String modelo, String marca, double preco, String cor){
            this.modelo=modelo;
            this.marca=marca;
            this.preco=preco;
            this.ano=ano;
            this.cor=cor;
	}
    
}
