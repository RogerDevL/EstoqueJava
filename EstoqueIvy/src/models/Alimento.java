package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Alimento extends Produto {

	public String dataValidade;

	public Alimento(int codigo, String nome, String descricao, int quantidade, double preco, String dataValidade) {
		super(codigo, nome, descricao, quantidade, preco);
		this.dataValidade = dataValidade;
	}

	public Alimento() {
		// TODO Auto-generated constructor stub
	}

	public String getDataValidade() {
		return dataValidade;
	}

	@Override
	public String exibirInfo() {
		return super.exibirInfo() + ", Data de Validade: " + dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String exibir() {
		return super.exibirInfo() + ", Data de Validade: " + dataValidade;
	}

	public void gravaEstoque() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
			writer.write(exibirInfo());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exibirEstoque() {
		try (BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AlimentoAdd() {
		do {
			System.out.println("Digite um codigo: ");
			try {
				setCodigo(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O código deve ser positivo");
				sc.nextLine();
			}
		} while (getCodigo() < 1);
		System.out.println("Digite um nome: ");
		setNome(sc.next());
		System.out.println("Digite uma descrição: ");
		setDescricao(sc.next());
		do {
			System.out.print("Digite a quantidade de produtos: ");
			try {
				setQuantidade(sc.nextInt());
			} catch (Exception e) {
				System.err.println("Apenas números inteiros...");
				sc.nextLine();
			}
		} while (getQuantidade() < 1);

		do {
			System.out.print("Digite um preço do produto: ");
			try {
				setPreco(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O preço deve ser positivo");
				sc.nextLine();
			}
		} while (getPreco() < 1);
		System.out.println("Digite uma data de validade: ");
		setDataValidade(sc.next());
		gravaEstoque();
	}

}
