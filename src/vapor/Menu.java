package vapor;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int opcao;

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
			System.out.println("            6 - Comprar jogo                              ");
			System.out.println("            0 - Sair                                      ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************");
			System.out.println("Entre com a opção desejada:                               ");
			System.out.println("                                                          ");
			opcao = scanner.nextInt();
			
			if(opcao == 0) {
				System.out.println("\nDesligando máquinas!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Adicionar jogo no Vapor \n\n");
				
				break;
			case 2:
				System.out.println("Listar todos os jogos \n\n");
				
				break;
			case 3:
				System.out.println("Procurar jogo pelo ID \n\n");
				
				break;
			case 4:
				System.out.println("Atualizar dados do jogo \n\n");
				
				break;
			case 5:
				System.out.println("Excluir jogo do Vapor \n\n");
				
				break;
			case 6:
				System.out.println("Comprar jogo \n\n");
				
				break;
			default:
				System.out.println("\nOpção inválida!\n");
				
				break;
			}
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
