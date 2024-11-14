package jogo.model;

public abstract class Principal {
	private int id;
	private int tipo;
	private String nome;
	private String desenvolvedor;
	
	
	public Principal(int id, int tipo, String nome, String desenvolvedor) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.desenvolvedor = desenvolvedor;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void baixarJogo(int id) {
		// Implementação incompleta, com classe controller devo verificar se o jogo existe na collection
		
		// possível nullpointerexception no momento
		if(this.id == id) {
			System.out.println("O jogo " + this.nome + " foi adquirido com sucesso! ");
		} else { 
			System.out.println("Esse jogo não existe no momento.");
		}
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = "P2P";
			break;
		case 2:
			tipo = "F2P";
			break;
		}
		System.out.println("\n\n**********************************************************");
		System.out.println("Dados do Jogo:");
		System.out.println("**********************************************************");
		System.out.println("ID do jogo: " + this.id);
		System.out.println("Nome do jogo: " + this.nome);
		System.out.println("Nome do desenvolvedor: " + this.desenvolvedor);
		System.out.println("Tipo do jogo: " + tipo);
		
	}
	
	
	
}
