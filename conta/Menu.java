package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		
		//Teste da Classe Conta Corrente
		
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Rodrigo", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		//Tesde da Classe Conta Poupança
		
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "João", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		int option;
		
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
			
				break;
			case 2: 
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas \n\n");
			
				break;
			case 3: 
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número \n\n");
			
				break;
			case 4: 
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta \n\n");
			
				break;
			case 5: 
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta \n\n");
			
				break;
			case 6: 
				System.out.println(Cores.TEXT_WHITE + "Saque \n\n");
			
				break;
			case 7: 
				System.out.println(Cores.TEXT_WHITE + "Depósito \n\n");
			
				break;
			case 8: 
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas \n\n");
			
				break;
			default: 
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida \n");
			
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
