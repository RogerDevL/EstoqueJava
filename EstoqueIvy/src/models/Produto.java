package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Produto {
	Scanner sc = new Scanner(System.in);
	private int codigo;
	private String nome;
	private String descricao;
	private int quantidade;
	private double preco;

	public Produto(int codigo, String nome, String descricao, int quantidade, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String exibirInfo() {
		return "Esse é o Código do produto: " + codigo + ", Esse é o nome do produto: " + nome
				+ ", Descrição do produto: " + descricao + ", Quantidade de produtos: " + quantidade
				+ ", Preço do produto: " + preco;

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

	public void ProdutoAdd() {
		do {
			System.out.println("Qual o código do produto?");
			try {
				setCodigo(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O código deve ser positivo");
				sc.nextLine();
			}
		} while (getCodigo() < 1);

		System.out.print("Digite um nome do produto: ");
		setNome(sc.next());

		System.out.print("Digite uma descrição do produto: ");
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
			System.out.print("Digite um preço dos produto: ");
			try {
				setPreco(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O preço deve ser positivo");
				sc.nextLine();
			}
		} while (getPreco() < 1);

		gravaEstoque();
	}
}
