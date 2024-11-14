package vapor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import jogo.model.FreeToPlay;
import jogo.model.PayToPlay;
import vapor.controller.VaporController;

public class Menu {

	public static void main(String[] args) {

		VaporController jogos = new VaporController();

		Scanner scanner = new Scanner(System.in);

		int opcao, id, tipo;
		String nome, desenvolvedor;
		boolean microTransacoes;
		float preco;

		while (true) {

			System.out.println("**********************************************************");
			System.out.println("                                                          ");
			System.out.println("                    WELCOME TO VAPOR                      ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************");
			System.out.println("                                                          ");
			System.out.println("            1 - Adicionar jogo                            ");
			System.out.println("            2 - Listar todos os Jogos                     ");
			System.out.println("            3 - Buscar jogo por ID                        ");
			System.out.println("            4 - Atualizar dados do Jogo                   ");
			System.out.println("            5 - Deletar jogo do Vapor                     ");
			System.out.println("            6 - Adquirir jogo                             ");
			System.out.println("            9 - Sair                                      ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************");
			System.out.println("Entre com a opção desejada:                               ");
			System.out.println("                                                          ");
			try {
				opcao = scanner.nextInt();
				scanner.skip("\\R?");
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				scanner.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println("\nDesligando máquinas!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Adicionar jogo no Vapor \n\n");
				System.out.println("Escreva o nome do jogo: ");
				nome = scanner.nextLine();
				
				System.out.println("Escreva o nome do desenvolvedor: ");
				desenvolvedor = scanner.nextLine();

				do {
					System.out.println("Digite o tipo de jogo: (1 - P2P ou 2 - F2P)");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o preço do jogo: ");
						preco = scanner.nextFloat();
						jogos.cadastrar(new PayToPlay(jogos.gerarNumero(), tipo, nome, desenvolvedor, preco));
					}
					case 2 -> {
						System.out.println("Informe se o jogo possui ou não microtransações (true - Possui ou false - Não possui): ");
						microTransacoes = scanner.nextBoolean();
						jogos.cadastrar(new FreeToPlay(jogos.gerarNumero(), tipo, nome, desenvolvedor, microTransacoes));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os jogos \n\n");
				jogos.listarJogos();
				keyPress();
				break;
			case 3:
				System.out.println("Procurar jogo pelo ID \n\n");
				System.out.println("Digite o ID do jogo: ");
				id = scanner.nextInt();
				
				jogos.procurarPorId(id);
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do jogo \n\n");
				System.out.println("Digite o ID do jogo: ");
				id = scanner.nextInt();
				scanner.skip("\\R?");
				
				var buscaJogo = jogos.buscarNaCollection(id);
				
				if(buscaJogo != null) {
					
					tipo = buscaJogo.getTipo();
					
					System.out.println("Escreva o nome do jogo: ");
					nome = scanner.nextLine();
					
					System.out.println("Escreva o nome do desenvolvedor: ");
					desenvolvedor = scanner.nextLine();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o preço do jogo: ");
							preco = scanner.nextFloat();
							jogos.atualizar(new PayToPlay(id, tipo, nome, desenvolvedor, preco));
						}
						case 2 -> {
							System.out.println("Informe se o jogo possui ou não microtransações (true - Possui ou false - Não possui): ");
							microTransacoes = scanner.nextBoolean();
							jogos.atualizar(new FreeToPlay(id, tipo, nome, desenvolvedor, microTransacoes));
						}
						default -> {
							System.out.println("Tipo de jogo inválido!");
						}
					}
				}else {
					System.out.println("O jogo não foi encontrado.");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Excluir jogo do Vapor \n\n");
				
				System.out.println("Digite o ID do jogo: ");
				id = scanner.nextInt();
				
				jogos.deletar(id);

				keyPress();
				break;
			case 6:
				System.out.println("Comprar jogo \n\n");
				
				System.out.println("Digite o ID do jogo:");
				id = scanner.nextInt();
				
				jogos.procurarPorId(id);
				
				System.out.println("Deseja adquirí-lo? (S ou N)");
				scanner.skip("\\R?");
				String resposta = scanner.nextLine();
				
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Jogo adquirido com sucesso!");
				} else { 
					System.out.println("Transação cancelada.");
				}
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção inválida!\n");

				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println("\n********************************************************");
		System.out.println("Projeto Desenvolvido por:                                 ");
		System.out.println("Pedro Vieira - pedrohq.vieira168@gmail.com                ");
		System.out.println("github.com/StPVieira                                      ");
		System.out.println("**********************************************************");

	}

}
