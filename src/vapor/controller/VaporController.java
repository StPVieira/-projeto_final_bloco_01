package vapor.controller;

import java.util.ArrayList;
import java.util.Scanner;
import jogo.model.Principal;
import vapor.repository.VaporRepository;

public class VaporController implements VaporRepository {

	private ArrayList<Principal> listaJogos = new ArrayList<Principal>();
	int id = 0;
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void procurarPorId(int id) {
		var jogo = buscarNaCollection(id);

		if (jogo != null) {
			jogo.visualizar();
		} else {
			System.out.println("\nO jogo com o ID: " + id + " não foi encontrado!");
		}

	}

	@Override
	public void listarJogos() {
		if (listaJogos.isEmpty()) {
			System.out.println("\nNenhum jogo cadastrado no momento.");
		} else {
			for (var jogo : listaJogos) {
				jogo.visualizar();
			}
		}

	}

	@Override
	public void cadastrar(Principal principal) {
		listaJogos.add(principal);
		System.out.println("\nO jogo de ID: " + principal.getId() + " foi adicionado com sucesso!");

	}

	@Override
	public void atualizar(Principal principal) {
		var buscaJogo = buscarNaCollection(principal.getId());

		if (buscaJogo != null) {
			listaJogos.set(listaJogos.indexOf(buscaJogo), principal);
			System.out.println("\nO jogo com ID: " + principal.getId() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO jogo com ID: " + principal.getId() + " não foi encontrado!");
		}

	}

	@Override
	public void deletar(int id) {
		var jogo = buscarNaCollection(id);
		if (listaJogos.remove(jogo)) {
			System.out.println("\nO jogo de ID: " + id + " foi deletado com sucesso!");
		} else {
			System.out.println("\nO jogo de ID: " + id + " não foi encontado!");
		}

	}

	public int gerarNumero() {
		return ++id;
	}
	
	public String escolherGenero() {
        System.out.println("\nEscolha o gênero:");
        System.out.println("1 - Ação");
        System.out.println("2 - Aventura");
        System.out.println("3 - RPG");
        System.out.println("4 - Estratégia");
        System.out.println("5 - Simulação");
        System.out.print("Digite o número do gênero desejado: ");
        
   
		int escolha = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (escolha) {
            case 1: return "Ação";
            case 2: return "Aventura";
            case 3: return "RPG";
            case 4: return "Estratégia";
            case 5: return "Simulação";
            default: 
                System.out.println("Opção inválida! Escolhendo 'Ação' por padrão.");
                return "Ação";
        }
    }
	
	public String escolherDesenvolvedor() {
        System.out.println("\nEscolha o desenvolvedor:");
        System.out.println("1 - Rockstar Games");
        System.out.println("2 - Ubisoft");
        System.out.println("3 - EA Games");
        System.out.println("4 - Blizzard Entertainment");
        System.out.println("5 - CD Projekt Red");
        System.out.print("Digite o número do desenvolvedor desejado: ");
        
        int escolha = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (escolha) {
            case 1: return "Rockstar Games";
            case 2: return "Ubisoft";
            case 3: return "EA Games";
            case 4: return "Blizzard Entertainment";
            case 5: return "CD Projekt Red";
            default: 
                System.out.println("Opção inválida! Escolhendo 'Rockstar Games' por padrão.");
                return "Rockstar Games";
        }
    }
	
	public void filtrarJogosPorGenero() {
	    String generoEscolhido = escolherGenero();
	    boolean jogosEncontrados = false;

	    System.out.println("\nJogos do gênero: " + generoEscolhido);
	    for (var jogo : listaJogos) {
	        if (jogo.getGenero().equalsIgnoreCase(generoEscolhido)) {
	            jogo.visualizar(); 
	            jogosEncontrados = true;
	        }
	    }

	    if (!jogosEncontrados) {
	        System.out.println("\nNenhum jogo encontrado para o gênero " + generoEscolhido);
	    }
	}

	public void filtrarJogosPorDesenvolvedor() {
	    String desenvolvedorEscolhido = escolherDesenvolvedor();
	    boolean jogosEncontrados = false;

	    System.out.println("\nJogos do desenvolvedor: " + desenvolvedorEscolhido);
	    for (var jogo : listaJogos) {
	        if (jogo.getDesenvolvedor().equalsIgnoreCase(desenvolvedorEscolhido)) {
	            jogo.visualizar();
	            jogosEncontrados = true;
	        }
	    }

	    if (!jogosEncontrados) {
	        System.out.println("\nNenhum jogo encontrado para o desenvolvedor " + desenvolvedorEscolhido);
	    }
	}

	public Principal buscarNaCollection(int id) {
		for (var jogo : listaJogos) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}

}
