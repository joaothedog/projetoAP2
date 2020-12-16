package ConcessionariaPop.model;

abstract class Carro {
	protected int ano;
	protected String modelo;
	protected String marca;
	protected double preco;

	public Carro(int ano, String modelo, String marca, double preco){
		this.modelo=modelo;
        this.marca=marca;
        this.preco=preco;
       	this.ano=ano;
	}
    
}
