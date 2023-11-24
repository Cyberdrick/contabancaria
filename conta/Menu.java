package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		ContaController contas = new ContaController();
		
		
		
		int option, number, agency, type, birthday;
		String holder;
		float balance, limit;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Mariana dos Santos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*********************************************************");
			System.out.println("												");
			System.out.println("		    BANCO DO BRAZIL  				  	");
			System.out.println("														 ");
			System.out.println("*********************************************************");
			System.out.println("														 ");
			System.out.println("	1 - Criar Conta  				  		 ");
			System.out.println("	2 - Listar todas as Contas 				 ");
			System.out.println("	3 - Buscar Conta por Número				 ");
			System.out.println("	4 - Atualizar Dados da Conta			 ");
			System.out.println("	5 - Apagar Conta			             ");
			System.out.println("	6 - Sacar		                         ");
			System.out.println("	7 - Depositar			              	 ");
			System.out.println("	8 - Transferir Valores entre Contas		 ");
			System.out.println("	9 - Sair		                     	 ");
			System.out.println("														 ");
			System.out.println("*********************************************************");
			System.out.println("Entre com a opcao desejada:                              ");
			System.out.println("														 ");
			
			try {
				option = read.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				read.nextLine();
				option=0;
			}
			
			if(option == 9) {
				System.out.println("\n Banco do Brazil. Seu futuro começa aqui!");
				sobre();
				read.close();
				System.exit(0);
			}
			
			switch(option) {
			case 1: 
				System.out.println(Cores.TEXT_WHITE + "Criar Conta \n\n");
				
				System.out.println("Digite o Numero da Agência: ");
				agency = read.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				read.skip("\\R?");
				holder = read.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					type = read.nextInt();
				}while(type < 1 && type > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				balance = read.nextFloat();
				
				switch(type) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limit = read.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agency, type, holder, balance, limit));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						birthday = read.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agency, type, holder, balance, birthday));
					}
				}
				
				keyPress();
				break;
			case 2: 
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3: 
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número \n\n");
				keyPress();
				break;
			case 4: 
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta \n\n");
				keyPress();
				break;
			case 5: 
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta \n\n");
				keyPress();
				break;
			case 6: 
				System.out.println(Cores.TEXT_WHITE + "Saque \n\n");
				keyPress();
				break;
			case 7: 
				System.out.println(Cores.TEXT_WHITE + "Depósito \n\n");
				keyPress();
				break;
			case 8: 
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas \n\n");
				keyPress();
				break;
			default: 
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida \n");
				keyPress();
				break;
			}
		}

	}
	
	public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("	Projeto Desenvolvido por: Rodrigo Schort     ");
			System.out.println("	Email:  rodrigoschort01@gmail.com"            );
			System.out.println("	Github: https://github.com/Cyberdrick"        );
	}
	
	public static void keyPress() {
		
		try {
			
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
			
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

}
