package models;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		System.out.println("##############################################");
		System.out.println("1-Cadastrar um novo produto no arquivo do estoque");
		System.out.println("2-Cadastrar um novo alimento no arquivo do estoque");
		System.out.println("3-Cadastrar um novo eletrônico no arquivo do estoque");
		System.out.println("4-Exibir as informações dos produtos do arquivo");
		System.out.println("9-Sair do sistema");
		System.out.println("##############################################");
	}

	public static void start() {
		boolean sistema = true;
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			System.out.print("Escolha sua opção: ");
			int escolha = sc.nextInt();
			Produto produto = new Produto();
			Alimento food = new Alimento();
			Eletronico eletro = new Eletronico();
			switch (escolha) {

			case 1:
				produto.ProdutoAdd();
				continue;
			case 2:
				food.AlimentoAdd();
				continue;
			case 3:
				eletro.EletronicoAdd();
				continue;

			case 4:
				produto.exibirEstoque();
				continue;
			case 9:
				System.out.println("Sistema encerrado....");
				sistema = false;
				break;
			}
		} while (sistema != false);

	}

}
