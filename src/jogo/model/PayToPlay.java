package jogo.model;

public class PayToPlay extends Principal {
	private float preco;

	public PayToPlay(int id, int tipo, String nome, String desenvolvedor, String genero, float preco) {
		super(id, tipo, nome, desenvolvedor, genero);
		this.preco = preco;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Preço do jogo: R$" + this.preco);
	}
	
}
