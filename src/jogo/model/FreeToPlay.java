package jogo.model;

public class FreeToPlay extends Principal {
	
	private boolean microTransacoes;

	public FreeToPlay(int id, int tipo, String nome, String desenvolvedor, String genero, boolean microTransacoes) {
		super(id, tipo, nome, desenvolvedor, genero);
		this.setMicroTransacoes(microTransacoes);
	}

	public boolean isMicroTransacoes() {
		return microTransacoes;
	}

	public void setMicroTransacoes(boolean microTransacoes) {
		this.microTransacoes = microTransacoes;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Possui microtransações? " + this.microTransacoes);
	}

}
