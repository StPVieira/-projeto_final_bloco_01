package vapor.controller;

import java.util.ArrayList;

import jogo.model.Principal;
import vapor.repository.VaporRepository;

public class VaporController implements VaporRepository{
	
	private ArrayList<Principal> listaJogos = new ArrayList<Principal>();
	int id = 0;
	
	@Override
	public void procurarPorId(int id) {
		var jogo = buscarNaCollection(id);
			
		if(jogo != null) {
				jogo.visualizar();
		} else {
			System.out.println("\nO jogo com o ID: " + id + " não foi encontrado!");
		}
		
	}

	@Override
	public void listarJogos() {
		for (var jogo : listaJogos) {
			jogo.visualizar();
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
		
		if(buscaJogo != null) {
			listaJogos.set(listaJogos.indexOf(buscaJogo), principal);
			System.out.println("\nO jogo com ID: " + principal.getId() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO jogo com ID: " + principal.getId() + " não foi encontrado!");
		}
		
	}

	@Override
	public void deletar(int id) {
		var jogo = buscarNaCollection(id);
		
		if(jogo != null) {
			if(listaJogos.remove(jogo) == true){
				System.out.println("\nO jogo de ID: " + id + " foi deletado com sucesso!");
			} else {
				System.out.println("\nO jogo de ID: " + id + " não foi encontado!");
			}
		}
		
	}
	
	public int gerarNumero() {
		return ++ id;
	}
	
	public Principal buscarNaCollection(int id) {
		for (var jogo : listaJogos) {
			if(jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}

}
